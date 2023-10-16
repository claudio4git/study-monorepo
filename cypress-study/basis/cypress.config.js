const { defineConfig } = require("cypress");

module.exports = defineConfig({
  e2e: {
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
  },
  env: {
    CYPRESS_BASE_URL: "www.google.com",
    CYPRESS_ENV_VARIABLE_CYPRESS_CONFIG_FILE: "hello cypress.config.fs file",
  },
});
