# Project
> Project to study Javascript

# Tips

- ES6 = EcmaScript 2015
- ES7 = EcmaScript 2016
- ES8 = EcmaScript 2017
- [Source](https://medium.com/@madasamy/javascript-brief-history-and-ecmascript-es6-es7-es8-features-673973394df4)

# Technologies

- HTML
- [Yarn](https://yarnpkg.com/)
- [Babel](https://babeljs.io/)

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

5 - Commands
```shell script
$ yarn dev
```
