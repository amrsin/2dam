
const n = 20;
let s = "* ";
console.log("Triangulo con N= " + n);
console.log();

for (let i = 0; i < n; i++ ) {

    s = s + "* ";
        

}
for (let i = 0; i < n; i++ ) {

    s = s.replace("* ", "");
    console.log(s);    

}