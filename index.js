var express = require('express');
var logger = require('morgan');
var bodyParser = require('body-parser');
var cors = require('cors');
var helmet = require('helmet');
var users = require('./routes/users');
var login = require('./routes/login');
var router = express.Router();
require('dotenv').load();

var app = express();
app.use(logger('dev'));
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.use(cors());
app.use(helmet());
app.use('/users', users);
app.use('/login', login);

 
app.get('/notes', function(req, res) {
  res.json({notes: "This is your notebook. Edit this to start saving your notes!", hello:{world:"hi",um:"ya"}})
})

app.get('/', function(req, res) {
  res.send("Welcome to the WhatToDo API server! How did you find me??? ;)")
})

//for heroku
var port = process.env.PORT || 3000;
 
app.use(function (error, request, response, next) {
    response.status(error.status || 500);
    response.json({ error: error.message });
});

var server = app.listen(3000, function () {
    var host = server.address().address;
    var port = server.address().port;

    console.log('App is listening on http://%s:%s', host, port);
});
