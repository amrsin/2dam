
const mongoose = require('mongoose');

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
    }
});

//model
let c_model = mongoose.model('auto_dealer', auto_dealerSchema);


//busqueda con find
let c1 = c_model.find().then(resultado => {
    let cadenaDOM = "";
    resultado.forEach(car => {
        cadenaDOM +=

            `
            <div class="col-xs-4 p-2">
            <div class="card text-center">
                <div class="card-header">

                <x-box style="align-items: center;
                justify-content: center;">
                  <h5 class="card-title">${car.brand + " " + car.model}</h5>
                  <x-icon name="edit" style="margin-bottom: 20px;"  id="icon_edit"></x-icon>
                </x-box>
                </div>
                <div class="card-body">
                  
                <label><strong>${car.license_plate}</strong></label><br>
                <label><strong>${car.year}</strong></label>
                <label><strong>|</strong></label>
                <label><strong>${car.color}</strong></label>
                <label><strong>|</strong></label>
                <label><strong>${car.kilometres}</strong></label>
                <label><strong>|</strong></label>
                <label><strong>${car.fuel}</strong></label>
                <label><strong>|</strong></label>
                <label><strong>${car.doors}</strong></label>
                <label><strong>doors |</strong></label>
                <label><strong>${car.gear_change}</strong></label>
                <label><strong>|</strong></label>
                <label><strong>${car.seats}</strong></label>
                <label><strong>seats</strong></label>

                </div>
                <div class="card-footer">
                  
                <x-box style= "align-items: center;
                justify-content: center;">
                    <x-icon name="delete" id="icon_dlt"></x-icon>
                </x-box>
                </div>
            </div>
            </div>
          `;
        document.getElementById("wrapper").innerHTML = cadenaDOM;

        let icon_edit = document.querySelectorAll('#icon_edit');
        icon_edit.forEach(icon => {
            icon.addEventListener('click', e => {
                alert('Modified');
            });
        })
        let icon_dlt = document.querySelectorAll('#icon_dlt');
        icon_dlt.forEach(icon => {
            icon.addEventListener('click', e => {
                alert('deleted');
            });
        })
    });
}).catch(error => {
    console.log("ERROR en find");
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

btn_save.addEventListener('click', () => {



    let txt_title = document.getElementById('txt_title').value;
    let txt_author_new = document.getElementById('txt_author_new').value;
    let txt_img = document.getElementById('txt_img').value;

    let new_book = new Libro({
        title: txt_title,
        author: txt_author_new,
        img: txt_img
    });

    let p = new_book.save().then(result => {
        console.log("book added:", result);
    }).catch(error => {
        console.log("ERROR adding book:", error);
    });

});*/
