var events = require('events');
var EventsE = events.EventEmitter;
var ee = new EventsE();
ee.on('data', function(date) {
console.log(date);
});
setInterval(function() {
ee.emit('data', new Date().toISOString()
);
}, 500);