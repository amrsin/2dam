const http=require('http');

var server = http.createServer(function (req,res) {
    console.log(req.url);
    res.writeHead(200, {'Content-type':'text/plain'});
    res.end('hello class');
    
});

server.listen(3000,'127.0.0.1');