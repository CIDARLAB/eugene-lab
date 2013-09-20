$(document).ready(function() {
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
                callback(dataJSON);
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
//        var data = '{"schema":"Part"}';
//        var channel = 'query';
//        var callback = function(data) {
//            $.each(data["data"], function(i, obj) {
//                alert("name: " + obj["name"] + "\nsequence" + obj["sequence"]["sequence"]);
//                $.each(obj,function(key,value){
//                alert(key+" "+value);    
//                });
//            });
//        };
//        send(channel, data, callback);
//        createTestData();
    };


    var send = function(channel, data, callback) {
        if (_connection.readyState === 1) {
            var message = '{"channel":"' + channel + '", "data":' + data + ',"requestId":"' + _requestID + '"}';
            alert("sending:\n" + message);
            _requestCommand[_requestID] = callback;
            _connection.send(message);
           _requestID++;
        } else {
            _connection = new WebSocket('ws://localhost:8080/websocket');
        }
    };



    var createTestData = function() {
        var data = '{"schema": "BasicPart", "name": "tester1", "sequence": "aaaaaaaaaaaaaaaaaa"}';
        send("create", data);
        var data = '{"schema": "BasicPart", "name": "tester2", "sequence": "tttttttttttttttttt"}';
        send("create", data);
        var data = '{"schema": "BasicPart", "name": "tester3", "sequence": "cccccccccccccccccc"}';
        send("create", data);
        var data = '{"schema": "BasicPart", "name": "tester4", "sequence": "gggggggggggggggggg"}';
        send("create", data);
    };



});