let data = [
    {name: "Nacho", telephone: "966112233", age: 40},
    {name: "Ana", telephone: "911223344", age: 35},
    {name: "Mario", telephone: "611998877", age: 15},
    {name: "Laura", telephone: "633663366", age: 17}
    ];
    
    let newPerson = {name: "Juan", phone: "965661564", age: 60};
    let newPerson2 = {name: "Rodolfo", telephone: "910011001", age: 20};
    
    
    let add_person  = new Promise ((resolve, reject) => {
        let result = data.filter (person => person.telephone != newPerson.telephone);

        if (result.length > 0) {

            data.push(newPerson);
            resolve (newPerson);
            
        }
       
        
        else
        
        reject ("exist in vector");
        
        });
        
        add_person.then(newPerson => {
        // If we are here the promise has been correctly processed
        
        console.log("added:");
      
        console.log(data);

        }).catch(error => {
        // if we are here there was an error
        
        console.log("Error:", error);
        })  
    
        

