
const fs = require('fs');

let btn_first = document.getElementById('btn_first');
let btn_back = document.getElementById('btn_back');
let btn_forward = document.getElementById('btn_forward');
let btn_last = document.getElementById('btn_last');
let btn_dlt = document.getElementById('btn_dlt');
let btn_insert = document.getElementById('btn_insert');

let clients = new Array();
let pos = 0;
let file = fs.readFileSync('./customers.json');

clients = JSON.parse(file);

let showCliente = () => {

    document.getElementById('DNI').value = clients[pos].dni;
    document.getElementById('Name').value = clients[pos].Name;
    document.getElementById('Telefone').value = clients[pos].telephone;

}

btn_first.addEventListener('click', () => {


    pos = 0;
    showCliente();
});

btn_back.addEventListener('click', () => {


    if (pos > 0) {
        pos--;
    }
    showCliente();
});


btn_forward.addEventListener('click', () => {

    
    pos ++
    if (pos == clients.length) {
        pos--;
    }
    showCliente();


});

btn_last.addEventListener('click', () => {

    
    pos = clients.length - + 1;
    showCliente();


});

