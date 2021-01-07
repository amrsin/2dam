//var
let text_celsius = document.getElementById("text_celsius");
let text_kelvin = document.getElementById("text_kelvin");
let btn_convert = document.getElementById("btn_convert");
let btn_clean = document.getElementById("btn_clean");

//listener for btn_convert
btn_convert.addEventListener('click', () => {

    if (text_celsius.value != "" ) {

        let celcius = parseFloat(text_celsius.value)
        let tokelvin = parseFloat(273.15 + celcius);
        text_kelvin.value = tokelvin;

    }
 
    /*if (text_kelvin.value != "") {

        let kelvin = parseFloat(text_kelvin.value)
        let tocelsius = parseFloat(kelvin - 273.15);
        text_celsius.value = tocelsius;
    }*/
});

//listener for btn_clean
btn_clean.addEventListener('click',() => {

    text_celsius.value = "";
    text_kelvin.value = "";

});