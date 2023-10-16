# Project
> Project to study Javascript

# Tips

- WebPack is a service that transorm many js files in one bundle file.

# Technologies

- React
- Yarn
- Babel
- WebPack

# Environment

1 - Install node and yarn.

2 - Execute the command in your workspace:
```sheel script
$ yarn init
$ yarn add @babel/cli
$ yarn add @babel/preset-env
$ yarn add @babel/core
$ yarn add @babel/plugin-proposal-object-rest-spread
```

3 - Babel configuratin
.babelrc
```
{
    "presets": ["@babel/preset-env"],
    "plugins": ["@babel/plugin-proposal-object-rest-spread"]
}
```

4 - Define scripts
package.json
```
    [...]
    "scripts": {
        "dev": "babel ./main.js -o ./bundle.js -w"
    }
```

5 - Execute the command in your workspace:
```shell script
$ yarn add webpack webpack-cli webpack-dev-server -D
$ yarn add babel-loader -D
```

6 - Webpack configuration
webpack.config.js
```
module.exports = {
    entry: './src/main.js',
    output: {
        path: __dirname + '/public',
        filename: 'bundle.js',
    },
    devServer: {
        contentBase: __dirname + 'public'
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: {
                    loader: 'babel-loader',
                }
            }
        ],
    },
};
```

7 - Define scripts
package.json
```
    [...]
    "scripts": {
        "dev": "webpack --mode=development -w"
    }
```

8 - Study

About Webpack dev server.