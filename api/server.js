var express = require('express'),
    app = express(),
    port = process.env.PORT || 9000, //tak ubah
    bodyParser = require('body-parser'),
    cors = require('cors'),
    controller = require('./controller');

app.use(cors());
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

var routes = require('./routes');
routes(app);

app.listen(port);
console.log('Learn Node JS , RESTful API server started on: ' + port);