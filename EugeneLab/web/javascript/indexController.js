$(document).ready(function() {
    var connection = new WebSocket('ws://localhost:8080/websocket');
//    connection.send('{"channel": "query", "data": {"schema":"org.clothocad.model.Part"},"messageID":"moo"}');
    connection.send('{"channel": "query", "data": {"schema":"org.clothocad.model.BasicPart"},"requestId":"moo"}');

    connection.onmessage = function(e) {
        alert("received a message");
        var data = e.data;
        //parse to json
        var channel = data["channel"];
        var actualData = data["data"];
        alert(actualData);
        //channels: create, destory, set, get, query, run 
    };
});


