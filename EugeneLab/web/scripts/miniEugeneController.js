/* Gets a list of images from the server and adds them to the imageList
 * Also adds a unique id to each part, viewable when clicked
 */


$(document).ready(function() {

    //$('#runButton') jquery syntax
    //assigns various functions to the run button when clicked
    $('#runButton').click(function() {
        
    	$('#outputArea').collapse('show');
        
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
            $.get("EugeneServlet", command, function(response) {
                alert(response);
            });
        } else {
            //Clicking run button sends current text to server
            //May want to modify to send file or collection of files to server(if Eugene program spans multiple files)

            $('#runButton').attr("disabled", "disabled");
            
            var command;
             
            command = {"input": editor.getValue(), 
                       "command":"solve", 
                       "N":$('#sizeOfDesign').val(),
                       //"NrOfSolutions":$('#nrOfSolutions').val(), 
                       "predefined":false};
             /**
                // Get file type to determine command
                var fileType = getFileType();
                var fileExtension = getCurrentFileExtension();
                
                // Command is based on the file type
                if(fileType === 'eug') {
                    command = {"input": editor.getValue(), "command":"execute"};
                } else if(fileType === 'sbol') {
                    command = {"input":fileExtension, "command":"executeSBOL"};
                } else if(fileType === 'gbk'|| fileType === 'gb') {
                    command = {"input":fileExtension, "command":"executeGenBank"};
                } else {
                    // @TODO: Add other file types
                }
                **/

            $.post("EugeneServlet", command, function(response) {
                $('#runButton').removeAttr("disabled");
                //alert(response["status"]);
                if ("good" === response["status"]) {
                    if (response["results"] !== undefined) {
                    	
                    	$('#outputExceptionArea').html('');

                    	// STATISTICS
                        var stats = '<div><table class="table table-bordered table-hover" id="outputList"><thead><tr><th>Name</th><th>Value</th><th></th></tr></thead><tbody>';
                    	$.each(response["stats"], function() {

                    		stats = stats + '<tr><td>' + this["name"] + '</td><td>' + this["value"] + '</td></tr>';
                        }
                        );
                    	stats = stats + '</tbody></table></div>';
                    	$('#outputStatsArea').html(stats);
                    	
                    	// SOLUTIONS TAB
                    	$('#outputEugeneArea').html('<div>Download the Eugene header file <a target="_blank" href=' + response["eugene"] + '>here</a></div>');
                    	
                    	// SBOL
                    	$('#outputSBOLArea').html('<div>Download the SBOL file <a target="_blank" href=' + response["sbol"] + '>here</a></div>');
                    	
                    	//$('#outputSolutionArea').html('<table class="table table-bordered table-hover" id="solutionList"><tr><td>p, c, r, t</td></tr><tr><td>p, c, t, r</td></tr><tr><td>p, r, c, t</td></tr><tr><td>p, r, t, c</td></tr><tr><td>p, t, c, r</td></tr><tr><td>p, t, r, c</td></tr><tr><td>r, c, p, t</td></tr><tr><td>r, c, t, p</td></tr><tr><td>r, p, t, c</td></tr><tr><td>r, p, c, t</td></tr><tr><td>r, t, c, p</td></tr><tr><td>r, t, p, c</td></tr><tr><td>c, p, r, t</td></tr><tr><td>c, p, t, r</td></tr><tr><td>c, r, p, t</td></tr><tr><td>c, r, t, p</td></tr><tr><td>c, t, r, p</td></tr><tr><td>c, t, p, r</td></tr><tr><td>t, c, p, r</td></tr><tr><td>t, c, r, p</td></tr><tr><td>t, r, p, c</td></tr><tr><td>t, r, c, p</td></tr><tr><td>t, p, r, c</td></tr><tr><td>t, p, c, r</td></tr></table>');
                    	// visualize the designs using pigeon

                        $.each(response["results"], function() {
                            $('#outputImageArea').html('<div class="item active"><img src="' + this["pigeon-uri"] + '"/>');
                        });
                        
                    }
                }
                else if ("exception" === response["status"]) {
                	// clean the other tabs
                    $("#outputStatsArea").html('');
                    $("#outputImageArea").html('');
                    $("#outputSolutionArea").html('');
                    $("#outputSBOLArea").html('');
                    $("#outputEugeneArea").html('');

                    
                    // print the exception
                	//$('#outputExceptionArea').html('<div class="item active">Exception: ' + response["results"] + '</div>');
                	$('#outputExceptionArea').html('Exception: ' + response["results"]);
                	
//                	var index = $('#outputTabs a[href="#outputExceptionTab"]').parent().index();
//                	$('#outputTabs').tabs('select', index);
                	
//                	$("#outputTabs").tabs("select", "#outputExceptionTab");
                }
                
                // regardless what happened, we visualize the ACT
            	$('#outputACTArea').html('<div class="item active"><img src="' + response["act-uri"] + '"/></div>');

            });
        }
    });


    //functions to run on page load
    var editor = CodeMirror.fromTextArea(document.getElementById("textEditor"), {
        styleActiveLine: true,
        lineNumbers: true,
        lineWrapping: true,
        theme: "neat",
        mode: "eugene"
    });

});

