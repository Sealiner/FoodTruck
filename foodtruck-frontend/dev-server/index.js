const express = require('express');
const webpackDevMiddleware = require('webpack-dev-middleware');
const webpack = require('webpack');

const compiler = webpack(require('../webpack.config.js'));
const handler = require('./handler');
const log = require('./log');
const routes = require('../src/routes.json');
const { createProxyMiddleware } = require('http-proxy-middleware');

// Create server
const app = express();

// Add a logger
app.use(log());

// Bind routes
routes.forEach(route => {
    app.get(route.pattern, handler(route));
});

//
const middlewareOptions = {};
app.use(webpackDevMiddleware(compiler, middlewareOptions));

// set a proxy here if needed
app.use('/api', createProxyMiddleware({target: 'http://127.0.0.1:8886/', changeOrigin: true}));

// Start listening
const port = process.env.PORT || 3001;
app.listen(port, function () {
    process.stdout.write('Server listening on port ' + port + '\n');
});
