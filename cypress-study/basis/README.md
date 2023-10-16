# About this project

This project contains cypress examples and basis commands to be used as guide.

## Project init

- Create a new NPM project
  `npm init -y`

- Install cypress on it
  `npm install --save-dev cypress`

- Install typescript on cypress project
  `npm install --save-dev typescript`

- Prettier instalation
  `npm install --save-dev --save-exact prettier`

- Running cypress tests
  `npx cypress open`

## Env configuration

- You can you Shell command to create envs
  `export CYPRESS_MY_ENV_VARIABLE="hello"`

- You can use `--env` from cypress to set envs
  `npx cypress open --env MY_ENV_VARIABLE="hello"`

- You can create `cypress.json` file to add your envs
- You also can create `cypress.env.json` file to add your envs

To get the env value you can use the command:

- `Cypress.env('MY_ENV_VARIABLE');`

## Running

Use the command `npm test` to run all tests.
