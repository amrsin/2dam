console.log(__dirname);
console.log(__filename);


const route = '/home/amrsin/2dam';
const fs = require('fs');
fs.readdirSync(route).forEach(file => {console.log(file);});


