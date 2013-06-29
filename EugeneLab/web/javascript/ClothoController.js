 var connection = new WebSocket('some_url');
connection.send('{"channel": "query", "data": {"schema":"Part"}}');

connection.onmessage = function(e) {
    var data = e.data;
    //parse to json
    var channel = data["channel"];
    var actualData = data["data"];
    //channels: create, destory, set, get, query, run 
};