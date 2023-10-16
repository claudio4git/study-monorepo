> AWS lambda - Nanosservice Album Project

# VSCode shortcuts

Ctrl + Shift + P
keymaps -> install Intellij keymaps

# Pre requisito

**S3 with name:** jccf-lambda-photo-album-bucket-images

# Create http-handler project

```shell
$ serverless create --template aws-nodejs --path http-handler
$ cd http-handler/
$ npm init
```

# Dependencies install

```shell
$ npm i serverless-apigw-binary --save-dev
$ npm i aws-sdk --save-dev
$ npm i uuid
```

# Deploy on AWS

```shell
$ sls deploy
```

# Endpoints

**Upload** POST https://URL/dev/images