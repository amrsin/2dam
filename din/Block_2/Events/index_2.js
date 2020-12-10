const events = require('events');
let EventsE = events.EventEmitter;
let ee = new EventsE();

ee.on('evento', function(mensaje) {
    console.log(mensaje);
    });
ee.emit('evento', 'el evento se ha emitido');

