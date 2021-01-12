let input_name = document.getElementById("input_name");
let input_surname = document.getElementById("input_surname");
let stick_size = document.getElementById("stick")
let radio_vegetables = document.getElementById("radio_vegetables");
let radio_classic = document.getElementById("radio_classic");
let chk_cheese = document.getElementById("chk_cheese");
let chk_spinach = document.getElementById("chk_spinach");
let chk_pepperoni = document.getElementById("chk_pepperoni");

let btn_ok = document.getElementById("btn_ok");
let type;
let toppings = ""; 


btn_ok.addEventListener('click', () => {

    if (input_name.value != "" && input_surname != "") {

        
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
        alert(input_name.value + " " + input_surname.value + " you odered " + type + ", with: " + toppings + ", " + stick_size.value + " size");
    }
})