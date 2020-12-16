const fs = require('fs');

var myStreamRead = fs.createReadStream(__dirname + '/english.txt', 'utf8');
//var myStream = fs.createReadStream(__dirname + '/english.txt',{highWaterMark: 1});
var myStreamWrite = fs.createWriteStream(__dirname + '/english_copy.txt');

myStreamRead.pipe(myStreamWrite);

myStreamRead.on('data', function (chunk) {

    console.log('nuevo trozo recibido ');
    console.log(chunk);
    myStreamWrite.write(chunk);
})






