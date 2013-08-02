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
//            connection.send('{"channel": "create", "data": {"schema":"BasicPart","name":"mooPart", "sequence":"CCCC"}, "requestId":"6"}');
//            connection.send('{"channel": "create", "data": {"schema":"BasicPart","name":"mooPart2", "sequence":"CCCC"}, "requestId":"7"}');
//            connection.send('{"channel": "create", "data": {"schema":"BasicPart","name":"mooPart3", "sequence":"CCCC"}, "requestId":"8"}');
//            connection.send('{"channel": "query",  "data": {"schema":"BasicPart"},"requestId":"9"}');

//            connection.close();
        }
    }
});


