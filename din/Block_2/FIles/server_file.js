/*const { ReadStream } = require('fs');
const http=require('http');
const file = require('./readme.json');
console.log(typeof(file));

var server = http.createServer(function (req, res) {

    
    res.writeHead(200, {'Content-type':'application/json'});

    res.end(JSON.stringify(file));
});

server.listen(3000, '127.0.0.1');*/


const { ReadStream } = require('fs');
const http=require('http');


var server = http.createServer(function (req, res) {

    
    res.writeHead(200, {'Content-type':'application/json'});
    var file = fs.readFileSync('readme.json', 'utf8')
    console.log(typeof(file));
    res.end(file);
});

server.listen(3000, '127.0.0.1');