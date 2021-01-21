
const fs = require('fs');


let DNI = document.getElementById('DNI').value;
let Name = document.getElementById('Name').value;
let Telefone = document.getElementById('Telefone').value;

let btn_first = document.getElementById('btn_first');
let btn_back = document.getElementById('btn_back');
let btn_forward = document.getElementById('btn_forward');
let btn_last = document.getElementById('btn_last');
let btn_dlt = document.getElementById('btn_dlt');
let btn_insert = document.getElementById('btn_insert');
let btn_update = document.getElementById('btn_update');
let controllerInsert = false;


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

    if (pos < clients.length - 1) {

        pos++;
        showCliente();

    }

    if (pos == clients.length) {
        pos--;
    }
    showCliente();

});

btn_last.addEventListener('click', () => {


    pos = clients.length - 1;
    showCliente();


});


btn_last.addEventListener('click', () => {


    pos = clients.length - 1;
    showCliente();


});

btn_update.addEventListener('click', () => {


    clients[pos].dni = DNI.value;
    clients[pos].Name = Name.value;
    clients[pos].telephone = Telefone.value;
    updateFile();
    alert('updated');

});

btn_dlt.addEventListener('click', () => {


    clients.splice(pos, 1);
    updateFile();
    alert('Deleted')
    showCliente();

});

btn_insert.addEventListener('click', () => {

    let (c_new) = {}

    if (!controllerInsert) {


        DNI.value = " ";
        Name.value = " ";
        Telefone.value = " ";
        controllerInsert = true;

        btn_insert.classList.remove("btn.primary");
        btn_insert.classList.add("btn-negative");

    }else {

        c_new = {

            dni: dni.value,
            Name: Name.value,
            Telefone: Telefone.value

        }
        clients.push(c_new);
        pos = clients.length -1;
        showCliente();

        btn_insert.classList.remove("btn.negative");
        btn_insert.classList.add("btn-primary");
    }
   



    updateFile();
    showCliente();

});

let updateFile = () => {

    fs.writeFileSync('./customers.json', JSON.stringify(clients));
}