var express = require('express')
 
var app = express()
 
app.get('/notes', function(req, res) {
  res.json({notes: "This is your notebook. Edit this to start saving your notes!", hello:{world:"hi",um:"ya"}})
})

app.get('/', function(req, res) {
  res.json({notes: "This is your notebook. Edit this to start saving your notes!"})
})

//for heroku
var port = process.env.PORT || 3000;
 
app.listen(port, function(){
  console.log('listening on *:'+port+'\nvisit http://localhost:3000/notes for test GET');
});
