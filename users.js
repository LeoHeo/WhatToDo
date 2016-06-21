var users = require('./routes/users');
var login = require('./routes/login');

app.use('/users', users);
app.use('/login', login);