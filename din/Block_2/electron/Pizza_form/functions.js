const fs = require('fs');

// var
let input_name = document.getElementById("input_name");
let input_surname = document.getElementById("input_surname");
let stick_size = document.getElementById("stick")
let radio_vegetables = document.getElementById("radio_vegetables");
let radio_classic = document.getElementById("radio_classic");
let chk_cheese = document.getElementById("chk_cheese");
let chk_spinach = document.getElementById("chk_spinach");
let chk_pepperoni = document.getElementById("chk_pepperoni");

let btn_order = document.getElementById("btn_order");
let btn_cancel = document.getElementById("btn_cancel")
let type = "";
let toppings = ""; 

//listener for btn_order
btn_order.addEventListener('click', () => {

    if (input_name.value != "" && input_surname.value != "") {

        
        if (radio_vegetables.checked) {

            type = radio_vegetables.value;

        }

        if (radio_classic.checked) {

            type = radio_classic.value;
        }

        if (chk_cheese.checked) {

            toppings = toppings + " " + chk_cheese.value;
            
        }

        if (chk_spinach.checked) {

            toppings = toppings + " " + chk_spinach.value;
        }

        if (chk_pepperoni.checked) {

            toppings = toppings + " " + chk_pepperoni.value;
        }

       
        if (toppings != "") {
        
            alert(input_name.value + " " + input_surname.value + " you odered \n " +" - Type: " + type + "\n - Toppings: " + toppings + " \n - Size: " + stick_size.value);
           

        }else {
            alert(input_name.value + " " + input_surname.value + " you odered \n " +" - Type: " + type  + " \n - Size: " + stick_size.value);

        }
    }
});

//listener for btn_cancel
btn_cancel.addEventListener('click', () => {

    if (input_name.value != "" && input_surname.value != "") {
       
        alert("Order canceled");

    }
});