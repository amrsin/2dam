const fs = require('fs');
// we load moongose
const mongoose = require('mongoose');
const { title } = require('process');

let file = fs.readFileSync('./books.json');

let libros = JSON.parse(file);
// we set the default promise engine to javascript
// this is necessary because mongo supports different types of promises
mongoose.Promise = global.Promise;
// connect with the contacts DB
const url = 'mongodb://localhost:27017/books';
mongoose.connect(url, {
    useNewUrlParser: true,
    useCreateIndex: true,
    useUnifiedTopology: true
}).then(() => { console.log('connection succesful') })

    .catch((err) => {
        console.log('connection error')
    });

//scheme
let booksSchema = new mongoose.Schema({
    title: String,
    autor: String,
    img: String
});


//esquem
contactSchema = new mongoose.Schema({
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
let p1

libros.forEach(book => {

    let libro = new books();
    libro.title = book.title;
    libro.autor = book.autor;
    libro.img = book.img;
    p1 = libro.save().then(result => {
        console.log("Book added:", result);
    }).catch(error => {
        console.log("ERROR adding  book:", error);
    });
});