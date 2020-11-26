let data = [
    {name: "Nacho", telephone: "966112233", age: 40},
    {name: "Ana", telephone: "911223344", age: 35},
    {name: "Mario", phone: "611998877", age: 15},
    {name: "Laura", telephone: "633663366", age: 17}
    ];

console.log(data);

console.log("  Ordered by age" )
data.sort(function(a, b) {
    
    if (a.age < b.age) {
        return -1;
    }

    if (a.age > b.age) {
      return 1;
    }
   
})
console.log(data);


console.log("  Ordered by name" )
data.sort(function(a, b) {
    
    if (a.name < b.name) {
        return -1;
    }

    if (a.name > b.name) {
      return 1;
    }
   
})
console.log(data);

