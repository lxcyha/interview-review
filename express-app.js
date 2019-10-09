var express = require('express')
var url = require('url')

var app = express()

app.get('/', function (req, res) {
    var urlObj = url.parse(req.url)
    var query = urlObj.query
    res.send('index')
})

app.listen(3000)

