function add(newPerson, data) {

    add_person  = new Promise ((resolve, reject) => {
        let result = data.filter (person => person.telephone == newPerson.telephone);
        if (result.length == 0) {

            data.push(newPerson);
            resolve (newPerson);
            
        }
         
        else
        
        reject ("Telefone exists in vector");
        
        });
        
        add_person.then(newPerson => {
        // If we are here the promise has been correctly processed
        
        console.log("added ", newPerson);
        }).catch(error => {
        // if we are here there was an error
        
        console.log("Error:", error, newPerson);

        })  
}

function remove(deletePerson, data) {

    remove_person = new Promise ((resolve, reject) => {
        let result = data.filter (person => person.telephone != deletePerson.telephone);
        console.log(result.length);
        if (result.length > 0) {

            resolve (result);
            
        }

        else
        
        reject ("The telefone doesn't exist in data");
        
        });
        
        remove_person.then(result => {
        // If we are here the promise has been correctly processed
        
        console.log("Without ", deletePerson);
        console.log(result);
        
        }).catch(error => {
        // if we are here there was an error
        
        console.log("Error:", error);

        })  
}
module.exports = {
    add: add,
    remove: remove
    };