var express = require('express');
var bodyParser = require('body-parser');
var os = require('os');

var app = express();
app.use(bodyParser.json());

app.post('/',function(req,res){
    var hostname = os.hostname();
    console.log('Host: '+hostname+' got triggered with:');
    console.log('  type:      '+req.body.type);
    console.log('  createdAt: '+req.body.createdAt);
    console.log('  contents:  '+JSON.stringify(req.body.contents, null, 2));
    console.log('------------------------');
    console.log('Full body:   '+JSON.stringify(req.body, null, 2));
    res.send('OK');
});

app.listen(3000, '0.0.0.0', function(){
    console.log('Running at Port 3000');
});