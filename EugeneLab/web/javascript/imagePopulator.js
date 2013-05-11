/* Gets a list of images from the server and adds them to the imageList
 * Also adds a unique id to each part, viewable when clicked
 */
$(document).ready(function() {

    var command = {"command": "imageList"};

    // Get the JSON object with the location of the images
    // JSON has key imageList with a value as a array of JSON objects with a single key "location"
    $.get("EugeneServlet", command, function(response) {
        var i =0;
        $.each(response, function() {
            var type=this["fileName"].split("\.")[0]
            $("#part-list").append('<li id="' + type + '"><img src="images/sbol_visual_jpeg/' + this["fileName"] + '"></li>');
            $("#image" + i).doubleClick(function() {
                //When clicked gives id name
                alert("creating new "+$(this).attr('id'));
            });
        i++;
        });
    });
});

