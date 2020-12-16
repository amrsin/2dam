let mDiv=document.getElementById("data");
mDiv.innerHTML="<p> Content of the div </p>";

// Create button
let button = document.createElement("button");
button.textContent="Button";
document.body.appendChild(button);

// handle button click event:
button.addEventListener('click', ()=>{
    alert('Button Click !!!');
    })