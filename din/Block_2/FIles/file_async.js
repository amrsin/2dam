const fs=require('fs');

fs.readFile('./readme.txt', 'utf8', (err, data) => {

    if (err) throw err;
    console.log('Reading asynchronous file');
    console.log(data);

    fs.writeFile('./writeme.txt', data, (err) =>  {

        if (err) throw err;
        err
          ? console.log(err)
          : console.log('File written correctly');
    })
 });

 fs.rename('readme.txt', 'leeme.txt', (err) => {

    if (err) throw err;
    console.log('Name changed');
 });

 fs.stat('leeme.txt', (err, stats) => {

    if (err) throw err;
    console.log(stats);
 });




 /*fs.writeFile('./folder_try/dlt_try.txt');

 fs.unlink('./folder_try/dlt_try.txt', function() {

    fs.rmdirSync('folder_try', function (err) {

        if (err) {

            throw err + ' borrando carperta folder_try';
        }
    });
 }, function (err) {
    
    if(err) {

        throw err + ' borrando archivo folder_try/dlt_try.txt';
    }

 });*/
