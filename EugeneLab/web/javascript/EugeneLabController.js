/* Gets a list of images from the server and adds them to the imageList
 * Also adds a unique id to each part, viewable when clicked
 */
$(document).ready(function() {
    $(function() {
        $(".sortable").sortable({
            revert: true,
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
            $("#iconArea").append('<div class="span5"><li class="draggable" title= "'+ type.replace(/-/g, ' ') + '" id="' + type + '"><div class="thumbnail"><img class="img-rounded" style="width:40px;height:80px" src="images/sbol_visual_jpeg/' + this["fileName"] + '"></div></li></div>');
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
    });
});

