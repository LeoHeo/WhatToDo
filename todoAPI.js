var express = require('express')
 
var app = express()
 
app.get('/notes', function(req, res) {
  res.json({notes: "This is your notebook. Edit this to start saving your notes!", hello:{world:"hi",um:"ya"}})
})


app.get('/', function(req, res) {
  res.json({notes: "This is your notebook. Edit this to start saving your notes!"})
})
 
app.listen(3000, function(){
  console.log('listening on *:3000\nvisit http://localhost:3000/notes for test GET');
});