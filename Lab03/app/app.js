const express = require('express');
const config = require('./config/config');
const logger = require('morgan');
const bodyParser = require('body-parser');
const userRouter = require('./routes/user');
const reviewRouter = require('./routes/review');
const sequelize = require('./models').sequelize;
const methodOverride = require('method-override');

const app = express();
process.env.NODE_ENV = 'development';

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(logger('dev'));
app.use(methodOverride('_method'));
app.use('/user', userRouter);
app.use('/review', reviewRouter);
app.use(express.static(__dirname + '/public'));

app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');

app.get('/', function (req, res) {
   res.render('index');
});

app.get('/create-page', function (req, res) {
   res.render('./partials/create');
});

app.get('/read-page', function(req, res) {

    res.render('./partials/read');
});


sequelize.sync({force: true});

const server = app.listen(global.gConfig.node_port, () => {
    console.log(`${global.gConfig.app_name} listening on port ${global.gConfig.node_port}`);
});

