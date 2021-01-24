
let txt_name = document.getElementById('txt_name');
let chk_1 = document.getElementById('chk_1');
let chk_2 = document.getElementById('chk_2');
let chk_3 = document.getElementById('chk_3');
let r1 = document.getElementById('r1');
let r2 = document.getElementById('r2');
let btn_try = document.getElementById('btn_try');


btn_try.addEventListener( 'click' , () => {

    let chk = "";
    let radio = ""; 

    if(chk_1.checked) {

        chk = chk + chk_1.value;

    }
    if(chk_2.checked) {

        chk = chk + chk_2.value;

    }
    if(chk_3.checked) {

        chk = chk + chk_3.value;

    }
    if(r1.checked) {

        radio = r1.value;

    }
    if(r2.checked) {

        radio = r2.value;

    }



    alert(txt_name.value + " "+ chk + " "+ radio );

})