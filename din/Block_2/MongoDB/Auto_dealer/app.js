
const mongoose = require('mongoose');
btn_save = document.getElementById('btn_save');

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
        alert("Car added")
        find();
    }).catch(error => {
        alert("Error adding car")

    });
});

/*
btn_buscar.addEventListener('click', () => {
    let txt_buscar = document.getElementById('txt_buscar').value;
    Libro.find({ title: { $regex: '.*' + txt_buscar + '.*' } }).then(resultado => {
        let cadenaDOM = "";
        resultado.forEach(book => {
            cadenaDOM +=
                `<div>
                    <x-box vertical>
                        <img src="./images/${book.img}" height="170" width="108">
                        <x-label><strong>${book.title}</strong></x-label>
                        <x-label>${book.author}</x-label>
                    </x-box>
                </div>`;
        });
        document.getElementById("wrapper").innerHTML = cadenaDOM;
    }).catch(error => {
        console.log("Error en find");
    });
});
/*
btn_author.addEventListener('click', () => {
    let txt_author = document.getElementById('txt_author').value;
    Libro.find({ author: { $regex: '.*' + txt_author + '.*' } }).then(resultado => {
        let cadenaDOM = "";
        resultado.forEach(book => {
            cadenaDOM +=
                `<div>
                    <x-box vertical>
                        <img src="./images/${book.img}" height="170" width="108">
                        <x-label><strong>${book.title}</strong></x-label>
                        <x-label>${book.author}</x-label>
                    </x-box>
                </div>`;
        });
        document.getElementById("wrapper").innerHTML = cadenaDOM;
    }).catch(error => {
        console.log("Error en find");
    });
});

btn_home.addEventListener('click', () => {

    let p1 = Libro.find().then(resultado => {
        let cadenaDOM = "";
        resultado.forEach(book => {
            cadenaDOM +=
                `<div>
                <x-box vertical>
                    <img src="./images/${book.img}" height="170" width="108">
                    <x-label><strong>${book.title}</strong></x-label>
                    <x-label>${book.author}</x-label>
                </x-box>
            </div>`;
        });
        document.getElementById("wrapper").innerHTML = cadenaDOM;
    }).catch(error => {
        console.log("ERROR en find");
    });
});

*/
let btn_dlt = document.getElementById('btn_dlt');
let txt_license_plate_dlt = document.getElementById('txt_license_plate_dlt');
btn_dlt.addEventListener('click', e => {
    
    c_model.find({ license_plate: txt_license_plate_dlt.value }).then(result => {

        if(result.length!=0) {
            c_model.remove({ license_plate: txt_license_plate_dlt.value }).then(result => {
                alert("Car deleted")
                find()
            }).catch(error => {
                alert('Error deleting car')
            });
        }else {
            alert("Car with license plate " + txt_license_plate_dlt.value + " doesn't exist in bd");
        }
        
    }).catch(error => {
        console.log("ERROR:", error);
    });
   
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
        console.log("ERROR en find");
    });
}