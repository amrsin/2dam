const people = require('./people.js');

let data = [
    {name: "Nacho", telephone: "966112233", age: 40},
    {name: "Ana", telephone: "911223344", age: 35},
    {name: "Mario", telephone: "611998877", age: 15},
    {name: "Laura", telephone: "633663366", age: 17}
    ];

    let new_Person = {name: "Juan", telephone: "965661564", age: 60};
    let new_Person2 = {name: "Rodolfo", telephone: "910011001", age: 20};
    let deletePerson = {telephone: "910011001"};
    
    people.add(new_Person, data);
    people.add(new_Person2, data);
    people.add(new_Person, data);
    people.remove(new_Person2, data);

