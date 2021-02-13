
const mongoose = require('mongoose');
let btn_save = document.getElementById('btn_save');
let btn_dlt = document.getElementById('btn_dlt');
let btn_search = document.getElementById('btn_search');
let btn_save_update = document.getElementById('btn_save_update');
let agree_button = document.getElementById('agree_button');
let txt_license_plate_dlt = document.getElementById('txt_license_plate_dlt');
let txt_license_plate_update = document.getElementById('txt_license_plate_update')
let txt_model_update = document.getElementById('txt_model_update')
let txt_brand_update = document.getElementById('txt_brand_update')
let txt_year_update = document.getElementById('txt_year_update')
let txt_color_update = document.getElementById('txt_color_update')
let txt_kilometres_update = document.getElementById('txt_kilometres_update')
let txt_fuel_update = document.getElementById('txt_fuel_update')
let txt_doors_update = document.getElementById('txt_doors_update')
let txt_gear_change_update = document.getElementById('txt_gear_change_update')
let txt_seats_update = document.getElementById('txt_seats_update')
let txt_price_update = document.getElementById('txt_price_update')
let notification = document.querySelector("#notification");
let input = document.querySelector("#input");
let id_car;

            
mongoose.Promise = global.Promise;
//conexión
mongoose.connect('mongodb://localhost:27017/auto_dealer', {
    useNewUrlParser: true,
    useUnifiedTopology: true
});
//esquem
let auto_dealerSchema = new mongoose.Schema({
    license_plate: {
        type: String,
        required: true,
        minlength: 1,
        unique: true,
        trim: true
    },
    brand: {
        type: String,
        required: true,
        minlength: 1,
        trim: true
    },
    model: {
        type: String,
        required: true,
        minlength: 1,
        trim: true
    },
    year: {
        type: String,
        required: true,
        minlength: 1,
        trim: true
    },
    color: {
        type: String,
        required: true,
        minlength: 1,
        trim: true
    },
    kilometres: {
        type: String,
        required: true,
        minlength: 1,
        trim: true
    },
    fuel: {
        type: String,
        required: true,
        minlength: 1,
        trim: true
    },
    doors: {
        type: String,
        required: true,
        minlength: 1,
        trim: true
    },
    gear_change: {
        type: String,
        required: true,
        minlength: 1,
        trim: true
    },
    seats: {
        type: String,
        required: true,
        minlength: 1,
        trim: true
    },

    price: {
        type: String,
        required: true,
        minlength: 1,
        trim: true
    }
});

//model
let c_model = mongoose.model('auto_dealer', auto_dealerSchema);


find();

btn_save.addEventListener('click', () => {

    let txt_license_plate = document.getElementById('txt_license_plate').value;
    let txt_brand = document.getElementById('txt_brand').value;
    let txt_model = document.getElementById('txt_model').value;
    let txt_year = document.getElementById('txt_year').value;
    let txt_color = document.getElementById('txt_color').value;
    let txt_kilometres = document.getElementById('txt_kilometres').value;
    let txt_fuel = document.getElementById('txt_fuel').value;
    let txt_doors = document.getElementById('txt_doors').value;
    let txt_gear_change = document.getElementById('txt_gear_change').value;
    let txt_seats = document.getElementById('txt_seats').value;
    let txt_price = document.getElementById('txt_price').value;

    let new_car = new c_model({
        license_plate: txt_license_plate,
        brand: txt_brand,
        model: txt_model,
        year: txt_year,
        color: txt_color,
        kilometres: txt_kilometres,
        fuel: txt_fuel,
        doors: txt_doors,
        gear_change: txt_gear_change,
        seats: txt_seats,
        price: txt_price
    });

    let c = new_car.save().then(result => {
        notification.innerHTML = "Car added " + txt_license_plate;
        notification.opened = true;
        console.log('Car added');
        find();
    }).catch(error => {
        notification.innerHTML = "Error adding add";
        notification.opened = true;
        console.log("Error adding car", error)

    });
});

btn_dlt.addEventListener('click', e => {
    
    c_model.find({ license_plate: txt_license_plate_dlt.value }).then(result => {

        if(result.length!=0) {
            c_model.remove({ license_plate: txt_license_plate_dlt.value }).then(result => {
                notification.innerHTML = "Car deleted " + txt_license_plate_dlt.value;
                notification.opened = true;
                console.log("Car deleted")
                find()
            }).catch(error => {
                notification.innerHTML = "Error deleting car";
                notification.opened = true;
                console.log('Error deleting car')
            });
        }else {
            notification.innerHTML = "Car with license plate " + txt_license_plate_dlt.value + " doesn't exist in bd";
            notification.opened = true;
            console.log("Car with license plate " + txt_license_plate_dlt.value + " doesn't exist in bd");
        }
        
    }).catch(error => {
        notification.innerHTML = "Error in delete";
        notification.opened = true;
        console.log("ERROR in delete", error);
    });
   
});

btn_search.addEventListener('click', e => {
    
    
    c_model.find({ license_plate: txt_license_plate_update.value }).then(result => {

        if(result.length!=0) {

            result.forEach(car =>{
                id_car = `${car.id}`; 
                txt_model_update.value = `${car.model}`;
                txt_brand_update.value = `${car.brand}`;
                txt_year_update.value = `${car.year}`;
                txt_color_update.value = `${car.color}`;
                txt_kilometres_update.value = `${car.kilometres}`;
                txt_fuel_update.value = `${car.fuel}`;
                txt_doors_update.value = `${car.doors}`;
                txt_gear_change_update.value = `${car.gear_change}`;
                txt_seats_update.value = `${car.seats}`;
                txt_price_update.value = `${car.price}`;
                
            }); 

        }else {
            alert("Car with license plate " + txt_license_plate_update.value + " doesn't exist in bd");
        }
        
    }).catch(error => {
        alert("ERROR in search");
    });  
});

btn_save_update.addEventListener('click', () => {

    c_model.findByIdAndUpdate(id_car,
    { license_plate: txt_license_plate_update.value,brand: txt_brand_update.value, model: txt_model_update.value,
    year: txt_year_update.value, color: txt_color_update.value, kilometres: txt_kilometres_update.value,
    fuel: txt_fuel_update.value, door: txt_doors_update.value, gear_change: txt_gear_change_update.value,
    seats: txt_seats_update.value, price: txt_price_update.value}, { new: true })
    .then(result => {
        notification.innerHTML = "Car modified " + txt_license_plate_update.value;
        notification.opened = true;
        find();
        console.log("Modified car:", result);
    }).catch(error => {
        notification.innerHTML = "Error modifying car";
        notification.opened = true;
        console.log("ERROR:", error);
    });
});
agree_button.addEventListener('click', () => {

    mongoose.connection.close();
    window.close()

});

function find() {

    let c1 = c_model.find().then(resultado => {
        let cadenaDOM = "";
        resultado.forEach(car => {
            cadenaDOM +=

                `
            <div class="col-xs-4 p-2" style="margin: 8px" >
            <div class="card text-center">
                <div class="card-header">

                <x-box style="align-items: center;
                justify-content: center;">
                  <h5 class="card-title">${car.brand + " " + car.model}</h5>
                </x-box>
                </div>
                <div class="card-body">
                  
                <label><strong>${car.license_plate}</strong></label><br>
                <label><strong>${car.year}</strong></label>
                <label><strong>|</strong></label>
                <label><strong>${car.color}</strong></label>
                <label><strong>|</strong></label>
                <label><strong>${car.kilometres}</strong></label>
                <label><strong>km |</strong></label>
                <label><strong>${car.fuel}</strong></label>
                <label><strong>|</strong></label>
                <label><strong>${car.doors}</strong></label>
                <label><strong>doors |</strong></label>
                <label><strong>${car.gear_change}</strong></label>
                <label><strong>|</strong></label>
                <label><strong>${car.seats}</strong></label>
                <label><strong>seats |</strong></label>
                <label><strong>${car.price}</strong></label>
                <label><strong>€</strong></label>

                </div>
            </div>
            </div>
          `;
            document.getElementById("wrapper").innerHTML = cadenaDOM;

            /*let icon_edit = document.querySelectorAll('#icon_edit');
            icon_edit.forEach(icon => {
                icon.addEventListener('click', e => {
                    alert('Modified');
                });
            })
            let icon_dlt = document.querySelectorAll('#icon_dlt');
            icon_dlt.forEach(icon => {
                icon.addEventListener('click', e => {
                    
    
                    let lbl_license = document.getElementById('lbl_license')
                        
                    
                
                    let c = c_model.remove({ license_plate: lbl_license.value }).then(result => {
                        
                    }).catch(error => {
                        console.log("ERROR:", error);
                    });
                });
            })*/
        });
    }).catch(error => {
        notification.innerHTML = "Error in find";
        notification.opened = true;
        console.log("ERROR in find");
    });
}