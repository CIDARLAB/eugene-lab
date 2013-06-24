/* Gets a list of images from the server and adds them to the imageList
 * Also adds a unique id to each part, viewable when clicked
 */


$(document).ready(function() {
    var deviceCount = 0;
    var command = {"command": "read"};
    $.get("EugeneServlet", command, function(response) {
        var toAppend = '<table class="table table-bordered table-hover" id="partsList"><thead><tr><th>Name</th><th>Type</th></tr></thead><tbody>';
        $.each(response["result"], function() {
            if (this["Type"].toLowerCase() !== "composite") {
                toAppend = toAppend + '<tr><td>' + this["Name"] + '</td><td>' + this["Type"] + '</td></tr>';
            }
        });
        toAppend = toAppend + "</tbody></table>";
        $('#partsListArea').html(toAppend);
        $("#partsList").dataTable({
            "bPaginate": false,
            "bScrollCollapse": true
        });
    });


    var command = {"command": "imageList"};
    // Get the JSON object with the location of the images
    // JSON has key imageList with a value as a array of JSON objects with a single key "location"

    $.get("EugeneServlet", command, function(response) {
        var i = 0;
        $('#iconArea').html("");
        $.each(response, function() {
            var type = this["fileName"].split("\.")[0];
            $("#iconArea").append('<div class="span5"><li class="draggable partIcon" title= "' + type.replace(/-/g, ' ') + '" id="' + type + '"><div class="thumbnail"><img class="img-rounded" style="width:40px;height:80px" src="images/sbol_visual_jpeg/' + this["fileName"] + '"></div></li></div>');
            $('#' + type).dblclick(function() {
                //When clicked gives id name
                alert("creating new " + $(this).attr('id'));
            });
            i = i + 1;
        });
        $('#iconArea .draggable').draggable({
            helper: "clone",
            connectToSortable: ".sortable, #trash",
            revert: "invalid"
        });
        $('#iconArea li').on("click", function() {
            $(".selected").removeClass("selected");
            $(this).parent().addClass("selected");
            refreshPartsList($(this).attr("title"));
        });
    });


    //load parts list


    //Functions
    var refreshPartsList = function(s) {
        //TODO render parts list
        $('#partsList').html(s);
    };

    

    //Event Handlers
    $('#startButton').click(function() {
        $('#newDeviceButton').trigger("click");
    });

    $('#newDeviceButton').click(function() {
        if (deviceCount === 0) {
            $('#spectaclesEditorArea button').remove();
            $('#trash').droppable({
                hoverClass: "droppable-hover",
                drop: function(event, ui) {
                    var element = ui.draggable.css('position', '');
                    if (element.hasClass('blank')) {
                        element.parent().remove();
                    }
                    if (!element.hasClass("partIcon")) {
                        $(this).append(element);
                        $(ui.draggable).fadeOut(500);
                    }
                }}
            );
        }
        $('#spectaclesEditorArea').append('<ul id="device' + deviceCount + '" class="device droppable sortable"><li class="blank" style="vertical-align:bottom;height:80px;width:80px;border:1px solid grey" title="Drag a part here to get started">New Design</li></ul>');
        $("#device" + deviceCount).sortable({
            revert: true
        });
        $("#device" + deviceCount).droppable({
            drop: function() {
                $(this).droppable("destroy");
                var firstItem = $(this).find("li.blank");
                firstItem.html('<strong>' + $(this).attr("id") + '</strong>');
                firstItem.addClass("notSortable");
                $(this).sortable({
                    revert: true,
                    items: "li:not(.notSortable)",
                    connectWith: "#trash",
                    stop: function(event, ui) {
                        var firstItem = $(ui.item).parent().find("li.blank");
                        $(ui.item).parent().prepend(firstItem);
                        ui.item.removeClass('partIcon');
                    }
                });
                firstItem.attr("title", "Select to edit device properties");
                $(this).prepend(firstItem);
                firstItem.attr("style", 'height:40px;width:80px;background:#0081c2;vertical-align:top;padding:5px');
                firstItem.addClass("rotatedText");
                firstItem.click(function() {
                    $('.selected').removeClass("selected");
                    $(this).addClass("selected");
                });
            }
        });
        deviceCount = deviceCount + 1;
    });

    $('#runButton').click(function() {
        var text = false; //is the text editor active?
        if($('div#textEditorTab').hasClass("active")) {
           text = true; 
        }
        if (!text) {
            var command = {};
            command["command"] = "run";
            command["devices"] = "";
            command["parts"] = [];
            var devices = "";
            $('#spectaclesEditorArea ul').each(function() {
                if ($(this).find("li").length > 1) {
                    var device = "Device " + $(this).attr("id") + "(";
                    var count = 0;
                    $(this).find("li").each(function() {
                        if (count > 0) {
                            device = device + $(this).attr("title").split(' ').join("") + ",";
                        }
                        count = count + 1;
                    });
                    device = device.substring(0, device.length - 1);
                    device = device + ")";
                    devices = devices + device + "|";
                }
            });
            devices = devices.substring(0, devices.length - 1);
            command["devices"] = devices;
            alert(command["devices"]);
            window.location.replace("http://cidar.bu.edu/ravencad/ravencad.html");
            $.get("EugeneServlet", command, function(response) {
                alert(response);
            });
        } else {
            //Clicking run button sends current text to server
            //May want to modify to send file or collection of files to server(if Eugene program spans multiple files)
            $('#runButton').click(function() {
                var input = $('textarea#textEditor').val();
                $.get("EugeneServlet", {"command":"execute","input": input}, function(response) {
                    alert(response["result"]);
//                    $('textarea#console').append(response);
                });
            });
        }

    });
    
    // <editor-fold defaultstate="collapsed" desc="File Explorer Functions">
    var currentFolder = 'root';
    var currentState = 0; //state 0: root directory, state 1: within a project, state 2: within a device
    var currentFile = null;
    var currentFileFolder = null;
    
    buildFileList(currentFolder);
    
    //Builds the file list from the server response
    function buildFileList(currentFolder) {
        var command = {'command': 'getFileList', 'currentFolder': currentFolder};
        $('#fileExplorerList').empty();
        $.get('EugeneServlet', command, function(response) {
            for(var i = 0; i < response.length; i++) {
                var name = response[i]['name'];
                var id ='__' + name; //double underscore to prevent html id collisions
                id = id.replace('.', '__DOT__'); //cannot have id with '.' character
                var isFile = response[i]["isFile"];
                $('#fileExplorerList').append('<li id='+ id + ' class="fileExplorerElement">' + name + '</li>');
                if(i === 0) {
                    $('#' + id).addClass('firstFileExplorerElement');
                }
                if (i === response.length - 1) {
                    $('#' + id).addClass('lastFileExplorerElement');
                }
                if(isFile) {
                    $('#' + id).addClass('fileExplorerFile');
                } else {
                    $('#' + id).addClass('fileExplorerFolder');
                }
            }
        });
    }
    
    function setAddNewText(currentState) {
        var addNew = $('#addNew');
        switch(currentState) {
            case 0:
                addNew.html('New Project');
            case 1: 
                addNew.html('New Device');
                break;
            case 2: 
                addNew.html('New File');
                break;
            default:
                addNew.html('In Glitch State');
        }
    }
    
    //Changes the file explorer when a folder is clicked
    $(document).on('click','.fileExplorerFolder', function() {
        currentState += 1;
        setAddNewText(currentState);
        currentFolder = currentFolder + '/' + this.id.substring(2); //need to remove double underscore and
        buildFileList(currentFolder);
    });
    
    //Code to load a file content from the server
    $(document).on('click', '.fileExplorerFile', function() {
        currentFile = this.id.substring(2).replace('__DOT__', '.');
        $('#currentFileName').html(currentFile + ' open');
        currentFileFolder = currentFolder;
        var command = {'command':'getFileContent', 'fileName': currentFile, 'currentFolder':currentFolder};
        $.get('EugeneServlet', command, function(response) {
            editor.setValue(response['fileContent'].split('__BR__').join( '\n'));
        });
    });
    
    //Saves the open file when clicked
    $('#fileSave').click(function() {
        var fileContent = editor.getValue();
        var command = {'command':'saveFileContent', 'fileName':currentFile, 'currentFolder':currentFileFolder, 'fileContent':fileContent};
        $.post('EugeneServlet', command);
    });
    
    //Functionality of the back button
    $('#fileExplorerBack').click(function() {
        if(currentFolder !== 'root') {
            currentState -= 1;
            setAddNewText(currentState);
            currentFolder = currentFolder.substring(0,currentFolder.lastIndexOf('/'));
            buildFileList(currentFolder);
        }
    });
    
    //Adds new file or folder depending on current location
    $('#addNew').click(function() {
        var newFileName = prompt('New File Name?');
        var isFile = false; //Only make a file when within a device, otherwise create a folder
        
        if(currentState === 2) { //If within a device then a file should be created
            isFile = true;
        }
        var command = {'command':'addNewFile', 'currentFolder':currentFolder, 'newFileName':newFileName, 'isFile':isFile};
        
        $.get('EugeneServlet', command, function(response) {
            buildFileList(currentFolder); //rebuild folder with current file list
            /* Bug here --- is never false
            if(response['fileCreateSucessful'] === false) {
                alert("File Already Exists");
            }
            */
        });
    });
    
    /* Delete Files --- still need some work
   
    $('#fileDelete').click(function() {
       var command = {'command':'deleteFile', 'fileName':currentFile, 'currentFolder':currentFolder};
       $.post('EugeneServlet', command, function() {
           buildFileList(currentFolder);
       });
    });
    
    $('.fileExplorerFile').bind("contextmenu", function(event) {
        event.preventDefault();
        $('<div class="popupDelete" id="' + this.id + 'fileMenu">Delete</div>')
            .appendTo("body")
            .css({top: event.pageY - 2 + "px", left: event.pageX - 2 + "px"});
    });
    
    $(document).bind("click", function(event) {
        if(!$(event.target).is('.popupDelete'))
            $("div.popupDelete").hide();
    });
    
    $(document).on('click', '.popupDelete', function() {
        var fileToDelete = this.id.replace('fileMenu', '').replace('__DOT__', '.').substring(2);
        var command = {'command':'deleteFile', 'fileName':fileToDelete, 'currentFolder':currentFolder};
       $.post('EugeneServlet', command, function() {
           buildFileList(currentFolder);
       });
    });
    
    */
    
    // </editor-fold>
});

