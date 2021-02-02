
// we load moongose
const mongoose = require('mongoose');
// we set the default promise engine to javascript
// this is necessary because mongo supports different types of promises
mongoose.Promise = global.Promise;
// connect with the contacts DB
const url = 'mongodb://localhost:27017/contacts';
mongoose.connect(url, {
    useNewUrlParser: true,
    useCreateIndex: true,
    useUnifiedTopology: true
}).then(() => { console.log('connection succesful') })

    .catch((err) => {
        console.log('connection error')
    });

//scheme
let contactSchema = new mongoose.Schema({
    Name: String,
    telephone: String,
    age: Number
});

//model
let Contact = mongoose.model('contacts', contactSchema);

//esquem
contactSchema = new mongoose.Schema({
    name: {
        type: String,
        required: true,
        minlength: 1,
        trim: true
    },
    telephone: {
        type: String,
        required: true,
        unique: true,
        trim: true,
        match: /^\d{9}$/
    },
    age: {
        type: Number,
        min: 18,
        max: 120
    }
});

// add documents
// first we create the contact
let contact1 = new Contact({
    name: "Boris",
    telephone: "946112230",
    age: 49
});
// we will use a save promise to save it to the database
let p1 = contact1.save().then(result => {
    console.log("Contact added:", result);
}).catch(error => {
    console.log("ERROR adding contact:", error);
});


// search with find
let p2 = Contact.find().then(result => {
    console.log(result);
}).catch(error => {
    console.log("ERROR:", error);
});


// find with parameters
let p3 = Contact.find({ name: 'Boris', age: 49 }).then(result => {
    console.log(result);
}).catch(error => {
    console.log("ERROR:", error);
});

/*// delete documents
let p4 = Contact.remove({ name: 'Boris' }).then(result => {
    console.log(result);
}).catch(error => {
    console.log("ERROR:", error);
});*/


let p5 = Contact.findByIdAndUpdate('601944c61de4cb5cff1c4e47',
    { name: 'Boris Anaya Moreno' }, { new: true })
    .then(result => {
        console.log("Modified contact:", result);
    }).catch(error => {
        console.log("ERROR:", error);
    });
Promise.all(p1, p2, p3, p5).then(values => {
    mongoose.connection.close();
});

