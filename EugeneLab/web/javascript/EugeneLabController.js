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
        $('tr').dblclick(function(){
            alert($(this).children("td:first").html());
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
        });
    });




    //Functions
    var refreshPartsList = function(s) {
        //TODO render parts list
        $('#partsList').html(s);
    };

    //load files list
    var loadFileTree = function() {
        $("#filesArea").html("");
        $.get("EugeneServlet", {"command": "getFileTree"}, function(data) {
            var children = data;
            $("#filesArea").dynatree({
                onActivate: function(node) {
                    // A DynaTreeNode object is passed to the activation handler
                    // Note: we also get this event, if persistence is on, and the page is reloaded.
//                alert("You activated " + node.data.title);
                },
                onDblClick: function() {
                    loadFile();
                },      
                persist: true,
                children: children
            });
        });
    };
    
    var getActiveNode = function() {
        return $("#filesArea").dynatree("getActiveNode");
    };
    
    // Return the active node's file extension
    var getActiveNodeExtension = function() {
        var node = getActiveNode();
        var nodeName = node.data.title;
            var parent = node.getParent();
            while (parent.data.title !== null) {
                nodeName = parent.data.title + "/" + nodeName;
                parent = parent.getParent();
            }
        if (node.data.isFolder) {
            nodeName += "/";
        }
        return nodeName;   
    };
    
    var addNewFolder = function(newFolderName) {
        var activeFolder = getActiveNodeExtension();
        var newFolderExtension = activeFolder + newFolderName + "/";
        var command = {"command": "addNewFolder", "extension": newFolderExtension };
        $.post("EugeneServlet", command, function(response) {
            var isSuccessful = response["isSuccessful"];
            alert(JSON.stringify(response));
            if(isSuccessful) {
                getActiveNode().addChild({
                    title: newFolderName,
                    isFolder: true
                });
            } else {
                alert("Folder name already exists");
            }
        });   
    };

    //save files
    var saveFile = function(newFileName) {
        $('#fileName').text(newFileName);
        var fileContent = editor.getValue();
        //create new file on server
        $.post("EugeneServlet", {"command": "saveFileContent", "fileName": newFileName, "fileContent": fileContent}, function(response) {
            //refresh file tree
            var rootNode = $("#filesArea").dynatree("getRoot");
            // Call the DynaTreeNode.addChild() member function and pass options for the new node
            var childNode = rootNode.addChild({
                title: newFileName,
                isFolder: false
            });
            //
            $('#newFileNameInput').val("");
        });
    };
    
    var getFileType = function() {
        var fileName = $('#fileName').text();
        var index = fileName.lastIndexOf('.');
        var fileType = fileName.substring(index + 1);
        return fileType;
             
    };
    
    
    var currentFileExtension;
    var setCurrentFileExtension = function(fileExtension) {
        currentFileExtension = fileExtension;
    };
    var getCurrentFileExtension = function() {
        return currentFileExtension;
    };
    
    var loadFile = function() {
        var node = getActiveNode();
        if (node.data.isFolder) {
            //do nothing i guess...
        } else {
            $('#fileName').text(node.data.title);
            var fileName = getActiveNodeExtension();
            setCurrentFileExtension(fileName);
            $.get("EugeneServlet", {"command": "getFileContent", "fileName": fileName}, function(response) {
                editor.setValue(response);

            });
        }
    };
    
    

    //Event Handlers
    $('#startButton').click(function() {
        $('#newDeviceButton').trigger("click");
    });

    $('#createNewButton').click(function() {
        var fileType = $("input:radio[name='file-type']:checked").val();
        var newFileName = $('#newFileNameInput').val() + '.' + fileType;
        saveFile(newFileName);
    });
    $('#saveButton').click(function() {
        var newFileName = $('#fileName').text();
        saveFile(newFileName);
    });

    $('#loadButton').click(function() {
        loadFile();
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
        if ($('div#textEditorTab').hasClass("active")) {
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

                $('#runButton').attr("disabled", "disabled");
                var command;
                
                // Get file type to determine command
                var fileType = getFileType();
                var fileExtension = getCurrentFileExtension();
                
                // Command is based on the file type
                if(fileType === 'eug') {
                    command = {"input": editor.getValue(), "command":"execute"};
                } else if(fileType === 'sbol') {
                    command = {"input":fileExtension, "command":"executeSBOL"};
                } else if(fileType === 'gbk') {
                    command = {"input":fileExtension, "command":"executeGenBank"};
                } else {
                    // @TODO: Add other file types
                }
                $.post("EugeneServlet", command, function(response) {
                    alert(JSON.stringify(response));  
                    $('#runButton').removeAttr("disabled");
                    if("good" == response["status"]) {
                        $.each(response["results"], function() {
                            //window.open(this["pigeon-uri"]);
                        });
                    } else {
                        console.log(response["error"]);                        
                    }
                });
        }

    });
            
        var editor = CodeMirror.fromTextArea(document.getElementById("textEditor"), {
                styleActiveLine: true,
                lineNumbers: true,
                lineWrapping: true,
                theme: "neat",
                mode: "eugene"
        });

    loadFileTree();

});

