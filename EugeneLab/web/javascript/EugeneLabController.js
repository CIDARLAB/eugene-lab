/* Gets a list of images from the server and adds them to the imageList
 * Also adds a unique id to each part, viewable when clicked
 */


$(document).ready(function() {
    /********"Field" Variables********/
    var deviceCount = 0;
    var _properties = {};
    var _partTypes = {};
    var _parts = [];



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
                var newValue = editor.getValue();
                var type = $(this).attr('id');
                if (_partTypes[type] === undefined) {
                    _partTypes[type] = "added";
                    newValue = 'PartType ' + type + '(name, sequence);\n' + newValue;
                }
                editor.setValue(newValue);
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


    /********Functions********/
    //load files list

    var drawPartsList = function(data) {
        var toAppend = '<table class="table table-bordered table-hover" id="partsList"><thead><tr><th>Name</th><th>Type</th></tr></thead><tbody>';
        $.each(data, function() {
            if (this["type"] !== undefined) {
                if (this["type"].toLowerCase() !== "composite") {
                    toAppend = toAppend + '<tr><td>' + this["name"] + '</td><td>' + this["type"] + '</td></tr>';
                    _parts[this["name"]] = this;
                }
            }
        });
        toAppend = toAppend + "</tbody></table>";
        $('#partsListArea').html(toAppend);
        $("#partsList").dataTable({
            "bPaginate": false,
            "bScrollCollapse": true
        });
        $('tr').dblclick(function() {
            var newValue = editor.getValue();
            var type = $(this).children("td:last").text();
            var name = $(this).children("td:first").text();
            if (_partTypes[type] === undefined) {
                _partTypes[type] = "added";
                newValue = 'PartType ' + type + '(name, sequence);\n' + newValue;
            }
            newValue = newValue + '\n' + type + ' ' + name + '(' + name + ',' + _parts[name].sequence + ');';
            editor.setValue(newValue);
        });
    };

    //draw the file table tree based on users file contents
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
                persist: true,
                children: children
            });
            $('#filesArea').dynatree("getTree").reload();
        });
    };

    //save files
    var saveFile = function(newFileName) {
        $('#fileName').text(newFileName);
        var fileContent = editor.getValue();
        //create new file on server
        $.post("EugeneServlet", {"command": "saveFileContent", "fileName": newFileName, "fileContent": fileContent}, function(response) {
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


    //Event Handlers
    $('#refreshButton').click(function() {
        var refreshType = $('ul#leftTabHeader li.active').text();
        if (refreshType === "Parts") {
            send("query", '{"className":"BasicPart"}', function(data) {
                drawPartsList(data);
            });

        } else {
            //refresh files
            loadFileTree();
        }
    });

    $('#createNewButton').click(function() {
        var input = $('#newFileNameInput').val();
        var newFileName = $('#newFileNameInput').val() + ".eug";
        if (input === "") {
            $('#uploadForm').submit();
        } else if ($('a.dynatree-title:contains("' + newFileName + '")').length === 0) {
            editor.setValue("");
            saveFile(newFileName);
        }
    });
    $('#saveButton').click(function() {
        var newFileName = $('#fileName').text();
        if ($('a.dynatree-title:contains("' + newFileName + '")').length === 0) {
            saveFile(newFileName);
        }
    });



    $('#deleteModalButton').click(function() {
        var node = $("#filesArea").dynatree("getActiveNode");
        if (node.data.isFolder) {
            //do nothing i guess...
        } else {
            var fileName = node.data.title;
            $('#toDeleteName').html("Do you really want to delete <strong>" + fileName + "</strong>?");

        }
    });

    $('#loadButton').click(function() {
        var node = $("#filesArea").dynatree("getActiveNode");
        if (node.data.isFolder) {
            //do nothing i guess...
        } else {
            var fileName = node.data.title;
            $('#fileName').text(fileName);
            var parent = node.getParent();
            while (parent.data.title !== null) {
                fileName = parent.data.title + "/" + fileName;
                parent = parent.getParent();
            }
            $.get("EugeneServlet", {"command": "getFileContent", "fileName": fileName}, function(response) {
                editor.setValue(response);
            });
        }
    });

    $('#deleteButton').click(function() {
        var node = $("#filesArea").dynatree("getActiveNode");
        if (node.data.isFolder) {
            //do nothing i guess...
        } else {
            var fileName = node.data.title;
            var parent = node.getParent();
            while (parent.data.title !== null) {
                fileName = parent.data.title + "/" + fileName;
                parent = parent.getParent();
            }
            $.get("EugeneServlet", {"command": "deleteFile", "fileName": fileName}, function() {
                node.remove();
            });
        }
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

            var input = editor.getValue();
            $('#runButton').attr("disabled", "disabled");

            $.post("EugeneServlet", {"command": "execute", "input": input}, function(response) {
                $('#runButton').removeAttr("disabled");

                if ("good" === response["status"]) {
                    var pigeonLinks = [];
                    var images = "";
                    $.each(response["results"], function() {
                        pigeonLinks.push(this["pigeon-uri"]);
                        images = images + '<li><img src="' + this["pigeon-uri"] + '" title="' + this["name"] + '" alt="' + this["name"] + '"/></li>';
                    });
                    //render images
                    images = '<ul id="imageList">' + images + '</ul>';
                    alert(images)
                    $('#outputImageArea').html(images);
                    $('#imageList').flowGallery({
                        easing: 'easeOutCubic',
                        backgroundColor: "white"
                    });
                    var newParts = {};
                    //render new parts list
                    var toAppend = '<table class="table table-bordered table-hover" id="outputList"><thead><tr><th>Name</th><th>Type</th></tr></thead><tbody>';
                    $.each(response["results"], function() {
                        if (newParts[this["name"]] === undefined && _parts[this["name"]] === undefined) {
                            newParts[this["name"]] = "added";
                            toAppend = toAppend + '<tr><td>' + this["name"] + '</td><td>' + this["type"] + '</td><td><button class="btn btn-success savePartButton">Save</button></td></tr>';
                        }
                        //handle each component
                        alert(this["components"])
                        $.each(this["components"], function() {
                            if (this["type"] !== undefined && newParts[this["name"]]===undefined && _parts[this["name"]] === undefined) {
                                newParts[this["name"]] = "added";
                                toAppend = toAppend + '<tr><td>' + this["name"] + '</td><td>' + this["type"] + '</td><td><button class="btn btn-success savePartButton">Save</button></td></tr>';
                            }
                        });
                    });
                    toAppend = toAppend + "</tbody></table>";
                    $('#outputListArea').html(toAppend);
                    $("#outputList").dataTable({
                        "bPaginate": false,
                        "bScrollCollapse": true
                    });
                    $('#output').append('<button class=btn btn-large btn-success" id="saveAllButton">Save All Parts</button>')
                    $('.savePartButton').click(function(){
                        //save a part
                        alert("saving a part")
                    })
                    $('#saveAllButton').click(function(){
                        //save all parts
                        alert("saving all parts")
                    })


                } else {
                    console.log(response["error"]);
                }
            });
        }

    });









    /********Clotho Functions and Variables********/
    var _connection = new WebSocket('ws://localhost:8080/websocket');

    var _requestCommand = {}; //key request id, value: callback function
    var _requestID = 0;


    _connection.onmessage = function(e) {
        //parase message into JSON
        var dataJSON = $.parseJSON(e.data);
        //ignore say messages which have not requestId
        var requestId = dataJSON["requestId"];
        if (requestId !== null) {
            //if callback function exists, run it
            var callback = _requestCommand[requestId];
            if (callback !== undefined) {
//                alert("calling back with: " + e.data)
                callback(dataJSON["data"]);
                //remove the callback
                delete _requestCommand[requestId];
            }
        }
    };

    _connection.onerror = function(e) {
        alert("F**K");
    };

    _connection.onclose = function() {
//        alert('closing connection');
    };

    _connection.onopen = function(e) {
        send("query", '{"className":"BasicPart"}', function(data) {
//            createTestData();
            drawPartsList(data);
        });
    };


    var send = function(channel, data, callback) {
        if (_connection.readyState === 1) {
            var message = '{"channel":"' + channel + '", "data":' + data + ',"requestId":"' + _requestID + '"}';
//            alert("sending:\n" + message);
            _requestCommand[_requestID] = callback;
            _connection.send(message);
            _requestID++;
        } else {
            _connection = new WebSocket('ws://localhost:8080/websocket');
        }
    };



    var createTestData = function() {
        var data = '{"schema": "BasicPart", "name": "tester1", "sequence": "aaaaaaaaaaaaaaaaaa", "type":"promoter"}';
        send("create", data);
        var data = '{"schema": "BasicPart", "name": "tester2", "sequence": "tttttttttttttttttt", "type":"rbs"}';
        send("create", data);
        var data = '{"schema": "BasicPart", "name": "tester3", "sequence": "cccccccccccccccccc", "type":"gene"}';
        send("create", data);
        var data = '{"schema": "BasicPart", "name": "tester4", "sequence": "gggggggggggggggggg", "type":"terminator"}';
        send("create", data);
    };











    //functions to run on page load

    var editor = CodeMirror.fromTextArea(document.getElementById("textEditor"), {
        styleActiveLine: true,
        lineNumbers: true,
        lineWrapping: true,
        theme: "neat",
        mode: "eugene"
    });

    loadFileTree();



//draw parts list using eugene servlet
// var command = {"command": "read"};
//    $.get("EugeneServlet", command, function(response) {
//        drawPartsList(response["result"])
//    });

});