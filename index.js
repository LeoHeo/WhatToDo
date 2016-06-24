var express = require('express'),
    path = require('path'),
    app = express(),
    router = express.Router(),
    r = require('rethinkdb')
require('rethinkdb-init')(r);

app.use(router);

//Rethink Configs
var dbConfig = {
    host: '127.0.0.1',
    port: 28015,
    db: 'whattodo',
    tables: {
  		todos: "todos"
    }
};

//Grab a RethinkDB connection
var conn;
r.connect({host: dbConfig.host, port: dbConfig.port}, function(err, connection) {
	conn = connection;
});

//Initialize a single database and table to a locally hosted RethinkDB server
r.init({
	    host: 'localhost',
	    port: 28015,
	    db: 'whattodo'
    },[
	    'todos'
    ]
).then(function (conn) {
  // All tables and indexes have been created 
});

//"homepage", aka all notes ;)
router.get('/', function(req, res) {	
	r.db(dbConfig.db).table(dbConfig.tables.todos)
     .run(conn).then(function(cursor) {
	    return cursor.toArray()
	}).then(function(results) {
	    // process the results
	    res.send(results)
	    console.log(results.length)
	});
	console.log("Someone hit /")
}); 

//GET DEVICE'S NOTES
router.get('/viewtodo/:usr', function(req, res) {
    var usr = req.params.usr;	
	r.db(dbConfig.db).table(dbConfig.tables.todos).filter({device:usr})
     .run(conn).then(function(cursor) {	
	    return cursor.toArray()	
	}).then(function(results) {	
	    // process the results
	    res.send(results)
	});
	console.log("Someone hit /viewtodo/"+usr);
});

//ADD NEW NOTE
router.get('/addtodo/:hash/:usr/:con/:dtl/:prio', function(req, res) {
    var todo = req.params.hash,
    	usr = req.params.usr,
    	con = req.params.con,
    	dtl = req.params.dtl,
    	prio = req.params.prio;
	r.db(dbConfig.db).table(dbConfig.tables.todos).insert({id:todo,user:usr,createdon:con,details:dtl,priority:prio})
     .run(conn).then(function(results) {
	    // process the results
	    if(results.inserted==1){
	    	res.send(true)
	    }else{
	    	res.send(false)
	    };
	});
	console.log("Someone hit /edittodo/"+todo+"/"+usr+"/"+con+"/"+dtl+"/"+prio)
});

//EDIT A TODO
router.get('/edittodo/:hash/:usr/:con/:dtl/:prio', function(req, res) {
    var todo = req.params.hash,
    	usr = req.params.usr,
    	con = req.params.con,
    	dtl = req.params.dtl,
    	prio = req.params.prio;
	r.db(dbConfig.db).table(dbConfig.tables.todos).get(todo).replace({id:todo,user:usr,createdon:con,details:dtl,priority:prio})
     .run(conn).then(function(results) {
	    // process the results
	    if(results.replaced==1){
	    	res.send(true)
	    }else{
	    	res.send(false)
	    }
	});
	console.log("Someone hit /edittodo/"+todo+"/"+usr+"/"+con+"/"+dtl+"/"+prio)
})

//DELETE A TODO
router.get('/deletetodo/:hash', function(req, res) {
    var todo = req.params.hash;	  	
	r.db(dbConfig.db).table(dbConfig.tables.todos).get(todo).replace(null)
     .run(conn).then(function(results) {
	    // process the results
	    if(results.deleted==1){
	    	res.send(true)
	    }else{
	    	res.send(false)
	    };
	console.log("Someone hit /deletetodo/"+todo)
	});
})


//for heroku
var port = process.env.PORT || 3000;
 
//Service! 
app.listen(port, function(){
    console.log('listening on *:'+port+'\nvisit http://localhost:3000/ to view all table entries in db:whattodo, table:todos');
});