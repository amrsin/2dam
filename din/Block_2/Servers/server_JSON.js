const http=require('http');

var server = http.createServer(function (req, res) {

    console.log(req.url);
    res.writeHead(200, {'Content-type':'application/json'});

    var miObj={
        name: 'Pepe',
        work: 'Programer',
        Age: 35
    }
    res.end(JSON.stringify(miObj));
});

server.listen(3000, '127.0.0.1');