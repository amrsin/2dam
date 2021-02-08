
const mongoose = require('mongoose');
let btn_buscar = document.getElementById("btn_buscar");
let btn_author = document.getElementById("btn_author");
let btn_home = document.getElementById("btn_home");
let btn_save = document.getElementById("btn_save");

mongoose.Promise = global.Promise;
//conexión
mongoose.connect('mongodb://localhost:27017/books', {
    useNewUrlParser: true,
    useUnifiedTopology: true
});
//esquema
let librosSchema = new mongoose.Schema({
    title: {
        type: String,
        required: true,
        minlength: 1,
        trim: true
    },
    author: {
        type: String,
        required: true,
        minlength: 1,
        trim: true
    },
    img: {
        type: String,
        required: true,
        minlength: 1,
        unique: true,
        trim: true
    }
});

//modelo
let Libro = mongoose.model('books', librosSchema);

//busqueda con find
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

});


/*const inicio = (books => {
    let cadenaDOM = "";
    books.forEach(book => {
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
});*/
