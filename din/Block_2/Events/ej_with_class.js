/*var events = require('events');

class Person extends events.EventEmitter {
constructor(name) {
super();
this.name = name;
}
}
var manu = new Person('Manu');
var boris = new Person('Boris');

manu.on('talk', function (message) {
    console.log(manu.name + ' has said ' + message)
});

boris.on('talk', function (message) {
    console.log(boris.name + ' has said ' + message)
});


manu.emit(`talk`, `I hope you study node`);
boris.emit(`talk`, `I add that a lot`);*/


var events = require('events');
var util = require('util');
class Person extends events.EventEmitter {
constructor(name) {
super();
this.name = name;
}
}
var manu = new Person('Manu');
var boris = new Person('Boris');
var people = [manu, boris];
people.forEach(function (littleperson) {
littleperson.on('talk', function (message) {
console.log(littleperson.name + ' has said ' + message)
});
})
manu.emit(`talk`, `I hope you study node`);
boris.emit(`talk`, `I add that a lot`);