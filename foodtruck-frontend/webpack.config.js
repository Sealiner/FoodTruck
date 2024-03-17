const path = require('path');
const defaults = require('lodash/defaults');
const templateConfig = require(path.join(__dirname, './src/template-config.js'));
// Plugins
const HtmlWebpackPlugin = require('html-webpack-plugin');
const MiniCssExtractPlugin = require('mini-css-extract-plugin')
const CopyWebpackPlugin = require('copy-webpack-plugin');
const { CleanWebpackPlugin } = require('clean-webpack-plugin');
const CssMinimizerPlugin = require("css-minimizer-webpack-plugin");
const UglifyJS = require('uglify-es');
const CleanCSS = require('clean-css');

// views routes
const routes = require(path.join(__dirname, './src/routes.json'));
const pageRoutes = routes.filter(function (route) {
    return !route.redirect;
});

const entry = {};
pageRoutes.forEach(function (route) {
    entry[route.name] = [
        path.join(__dirname, `./src/views/${route.view}.jsx`)
    ];
});

module.exports = {
    mode: process.env.mode || 'development',
    entry: entry,
    output: {
        path: path.resolve(__dirname, 'build'),
        filename: 'js/[name]-[fullhash]-bundle.js',
        publicPath: '/'
    },
    module: {
        rules: [
            {
                test: /\.jsx?$/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: [
                            ['@babel/preset-env',{targets: {
                                    esmodules: true,
                                }}],
                            '@babel/preset-react'
                        ],
                        plugins: [
                            ["@babel/plugin-transform-runtime",
                                {
                                    regenerator: true
                                }]
                        ]
                    }
                }
            },
            {
                test:/\.(css|less)$/,
                use:[
                    MiniCssExtractPlugin.loader,
                    'css-loader',
                    {
                        loader: 'postcss-loader',
                        options: {
                            postcssOptions: {
                                plugins: [
                                    [
                                        'autoprefixer'
                                    ],
                                ],
                            },
                        }
                    },
                    'less-loader'
                ]
            },
        ]
    },
    plugins:[
        new CleanWebpackPlugin(),
        new MiniCssExtractPlugin({
            filename: '[name]-[fullhash]-bundle.css'
        }),
        new CssMinimizerPlugin()
    ].concat(pageRoutes
        .map(function (route) {
            return new HtmlWebpackPlugin(defaults({}, {
                title: route.title,
                mode: process.env.mode || 'development',
                filename: route.name + '.html',
                basePath: '/',
                route: route,
                chunks: [route.name],
                dynamicMetaTags: route.dynamicMetaTags
            }, templateConfig));
        })
    ).concat([
        new CopyWebpackPlugin({
            patterns:[
                {
                    from: path.join(__dirname, './static/css'),
                    to: 'css',
                    transform: function (content) {
                        return new CleanCSS({}).minify(content).styles;
                    }
                },
                // uncomment code below if you have these static resources
                /*{
                    from: path.join(__dirname, './static/js'),
                    to: 'js',
                    transform: function (content) {
                        return UglifyJS.minify(content.toString()).code;
                    },
                },
                {
                    from: path.join(__dirname, './static/images'),
                    to: 'images'
                },
                {
                    from: path.join(__dirname, './static/favicon'),
                    to: 'favicon'
                },
                {
                    from: path.join(__dirname, './static/other'),
                    to: 'other'
                },*/
            ],
        })
    ])
};