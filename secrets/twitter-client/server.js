var express = require("express");
var Twitter = require("twitter");
var mustacheExpress = require("mustache-express");
var os = require("os");
var fs = require("fs");

// ********************************
// Add code here to read secrets...
// ********************************

var app     = express();
app.set('view engine', 'html');
app.engine('html', mustacheExpress()); 
app.set('views', __dirname);

app.get('/favorites',function(req,res){
    var hostname = os.hostname();
    client.get('favorites/list', function(error, tweets, response) {
        if(error) throw error;
        res.render('index', {
            tweets: tweets,
            hostname: hostname
        });
    });
});

app.listen(3000, '0.0.0.0', function(){
    console.log("Running at 0.0.0.0:3000");
});