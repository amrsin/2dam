const mongoose = require('mongoose');
mongoose.Promise = global.Promise;
//conexión
mongoose.connect('mongodb://localhost:27017/books', {
    useNewUrlParser: true,
    useUnifiedTopology: true
});


//esquem
let booksSchema = new mongoose.Schema({
    title: {
        type: String,
        required: true,
        minlength: 1,
        trim: true
    },
    autor: {
        type: String,
        required: true,
        minlength: 1,
        trim: true
    },
    img: {
        type: String,
        required: true,
        unique: true,
        minlength: 1,
        trim: true
    }
});

//model
let books = mongoose.model('books', booksSchema);
//busqueda con find
let p1 = books.find().then(resultado => {
    // inicio(resultado);
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