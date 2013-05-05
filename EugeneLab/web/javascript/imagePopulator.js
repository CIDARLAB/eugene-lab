/* Gets a list of images from the server and adds them to the imageList
 * Also adds a unique id to each part, viewable when clicked
 */
$(document).ready(function() {
    
    var command = {"command": "getImageList"};
    
    // Get the JSON object with the location of the images
    // JSON has key imageList with a value as a array of JSON objects with a single key "location"
    $.get("DemoServlet", command, function(response) {
        var imageList = $.parseJSON(response).imageList;
        var numberOfImages = imageList.length;
        var idList = new Array();
        // Iterate over imageList array and append image to the HTML list, with id="imagei"
        for(var i = 0; i < numberOfImages; i++) {
            $("#part-list").append("<li id='image" + i + "'><img src='sbol_visual_jpeg/" + imageList[i].location + "'></li>");
            $("#image" + i).click(function() {
                //When clicked gives id name
                alert($(this).attr('id'));
            });
        }
    });
});

