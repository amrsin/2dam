const fs = require('fs');
// we load moongose
const mongoose = require('mongoose');
const { title } = require('process');

let file = fs.readFileSync('./auto_dealer.json');

let cars = JSON.parse(file);
// we set the default promise engine to javascript
// this is necessary because mongo supports different types of promises
mongoose.Promise = global.Promise;
// connect with the contacts DB
const url = 'mongodb://localhost:27017/auto_dealer';
mongoose.connect(url, {
    useNewUrlParser: true,
    useCreateIndex: true,
    useUnifiedTopology: true
}).then(() => { console.log('connection succesful') })

    .catch((err) => {
        console.log('connection error')
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
let c1;

cars.forEach(car_aux => {

    let car = new c_model();

    car.license_plate = car_aux.license_plate;
    car.brand = car_aux.brand;
    car.model = car_aux.model;
    car.year = car_aux.year;
    car.color = car_aux.color;
    car.kilometres = car_aux.kilometres;
    car.fuel = car_aux.fuel;
    car.doors = car_aux.doors;
    car.gear_change = car_aux.gear_change;
    car.seats = car_aux.seats;
    car.price = car_aux.price;
    c1 = car.save().then(result => {
        console.log("car added:", result);
    }).catch(error => {
        console.log("ERROR adding  car:", error);
    });
   
});