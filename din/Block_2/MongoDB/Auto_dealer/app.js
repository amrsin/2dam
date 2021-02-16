
const mongoose = require('mongoose');


//for add dialog
let txt_license_plate = document.getElementById('txt_license_plate');
let txt_brand = document.getElementById('txt_brand');
let txt_model = document.getElementById('txt_model');
let txt_year = document.getElementById('txt_year');
let txt_color = document.getElementById('txt_color');
let txt_kilometres = document.getElementById('txt_kilometres');
let txt_fuel = document.getElementById('txt_fuel');
let txt_doors = document.getElementById('txt_doors');
let txt_gear_change = document.getElementById('txt_gear_change');
let txt_seats = document.getElementById('txt_seats');
let txt_price = document.getElementById('txt_price');
let btn_save = document.getElementById('btn_save');
let btn_dlt = document.getElementById('btn_dlt');
//for delete dialog
let txt_license_plate_dlt = document.getElementById('txt_license_plate_dlt');
//for update dialog
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
let btn_search = document.getElementById('btn_search');
let btn_save_update = document.getElementById('btn_save_update');

let notification = document.querySelector("#notification");
let agree_button = document.getElementById('agree_button');
let id_car;
let progress = document.getElementById("progress")


            
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


find(); //method for list all cars from bd

//method for add car to bd
btn_save.addEventListener('click', () => {

   

    let new_car = new c_model({
        license_plate: txt_license_plate.value,
        brand: txt_brand.value,
        model: txt_model.value,
        year: txt_year.value,
        color: txt_color.value,
        kilometres: txt_kilometres.value,
        fuel: txt_fuel.value,
        doors: txt_doors.value,
        gear_change: txt_gear_change.value,
        seats: txt_seats.value,
        price: txt_price.value
    });

    let c = new_car.save().then(result => {
        notification.innerHTML = "Car added " + txt_license_plate.value;
        notification.opened = true;
        console.log('Car added');
        txt_license_plate.value = ""; txt_brand.value = ""; txt_model.value = ""; txt_year.value = ""; txt_color.value = ""; txt_kilometres.value = ""; 
        txt_fuel.value = ""; txt_doors.value = ""; txt_gear_change.value=""; txt_seats.value = ""; txt_price.value="";

        find();
    }).catch(error => {
        notification.innerHTML = "Error adding add";
        notification.opened = true;
        console.log("Error adding car", error)

    });
});

//method for delete car to bd
btn_dlt.addEventListener('click', e => {
    
    c_model.find({ license_plate: txt_license_plate_dlt.value }).then(result => {

        if(result.length!=0) {
            c_model.remove({ license_plate: txt_license_plate_dlt.value }).then(result => {
                notification.innerHTML = "Car deleted " + txt_license_plate_dlt.value;
                notification.opened = true;
                console.log("Car deleted")
                txt_license_plate_dlt.value = "";
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

//method for search car to bd
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

//method for update car in bd
btn_save_update.addEventListener('click', () => {

    c_model.findByIdAndUpdate(id_car,
    { license_plate: txt_license_plate_update.value,brand: txt_brand_update.value, model: txt_model_update.value,
    year: txt_year_update.value, color: txt_color_update.value, kilometres: txt_kilometres_update.value,
    fuel: txt_fuel_update.value, door: txt_doors_update.value, gear_change: txt_gear_change_update.value,
    seats: txt_seats_update.value, price: txt_price_update.value}, { new: true })
    .then(result => {
        notification.innerHTML = "Car modified " + txt_license_plate_update.value;
        notification.opened = true;
        txt_license_plate_update.value = ""; txt_brand_update.value = ""; txt_model_update.value = ""; txt_year_update.value = ""; txt_color_update.value = ""; 
        txt_kilometres_update.value = ""; txt_fuel_update.value = ""; txt_doors_update.value = ""; txt_gear_change_update.value=""; txt_seats_update.value = "";
        txt_price_update.value="";
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

//method for find all cars in bd
function find() {

    c_model.find().then(resultado => {
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
            progress.style.display = 'none';

        });
    }).catch(error => {
        notification.innerHTML = "Error in find";
        notification.opened = true;
        console.log("ERROR in find");
    });
}