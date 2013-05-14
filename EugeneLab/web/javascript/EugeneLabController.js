/* Gets a list of images from the server and adds them to the imageList
 * Also adds a unique id to each part, viewable when clicked
 */
$(document).ready(function() {
    var deviceCount = 0;



    var command = {"command": "imageList"};
    // Get the JSON object with the location of the images
    // JSON has key imageList with a value as a array of JSON objects with a single key "location"
    $.get("EugeneServlet", command, function(response) {
        var i = 0;
        $('#iconArea').html("");
        $.each(response, function() {
            var type = this["fileName"].split("\.")[0];
            $("#iconArea").append('<div class="span5"><li class="draggable" title= "' + type.replace(/-/g, ' ') + '" id="' + type + '"><div class="thumbnail"><img class="img-rounded" style="width:40px;height:80px" src="images/sbol_visual_jpeg/' + this["fileName"] + '"></div></li></div>');
            $('#' + type).dblclick(function() {
                //When clicked gives id name
                alert("creating new " + $(this).attr('id'));
            });
            i = i + 1;
        });
        $('#iconArea .draggable').draggable({
            helper: "clone",
            connectToSortable: ".sortable",
            revert: "invalid"
        });
        $('#iconArea li').on("click", function() {
            $(this).parent().addClass("selected");
            refreshPartsList($(this).attr("title"));
        });
        $('#iconArea li').on("mouseleave", function() {
            $(this).parent().removeClass("selected");
        });
    });

    //Functions
    var refreshPartsList = function(s) {
        //TODO render parts list
        $('#partsList').html(s);
    };


    //Event Handlers
    $('#newDeviceButton').click(function() {
        if (deviceCount === 0) {
            $('#spectaclesEditorArea').html("");
        }
        $('#spectaclesEditorArea').append('<ul id="device' + deviceCount + '" class="device droppable sortable"><li class="blank" style="height:80px;width:80px;border:1px solid grey" title="Drag a part here to get started">New Device</li></ul>');
        $("#device" + deviceCount).sortable({
            revert: true
        });
        $("#device" + deviceCount).droppable({
            drop: function() {
                $(this).find("li.blank").remove();
            }
        });
        deviceCount = deviceCount + 1;
    });

    $('#runButton').click(function() {
        $('li.blank').parent().remove();
        $('li.blank').remove();
        var command = {};
        command["command"] = "run";
        command["devices"] = [];
        command["parts"] = [];
        $('#spectaclesEditorArea ul').each(function() {
            var device = "Device " + $(this).attr("id") + "(";
            //            command["devices"].push($(this).attr("id"));
            $(this).find("li").each(function() {
                device = device + $(this).attr("title").split(' ').join("") + ",";
            });
            device = device.substring(0, device.length - 1);
            device = device + ")";
            command["devices"].push(device);
        });
    });

});

