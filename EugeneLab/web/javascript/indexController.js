$(document).ready(function() {
    var connection = new WebSocket('ws://localhost:8080/websocket');
//    connection.send('{"channel": "query", "data": {"schema":"org.clothocad.model.Part"},"messageID":"moo"}');



    connection.onmessage = function(e) {
//        alert("received a message");
    };

    connection.onerror = function(e) {
        alert("fuck");
    };

    connection.onclose = function() {
        alert('closing');
    }

    if (connection.readyState == 1) {
        connection.send('{"channel": "query", "data": {"schema":"BasicPart"},"requestId":"moo3"}');
    }
    else {
        connection.onopen = function(e) {
        }
    }
});


