 var connection = new WebSocket('ws://localhost:8181/clotho/websocket');
connection.send('{"channel": "query", "data": {"schema":"Part"}}');

connection.onmessage = function(e) {
    var data = e.data;
    //parse to json
    var channel = data["channel"];
    var actualData = data["data"];
    //channels: create, destory, set, get, query, run 
};