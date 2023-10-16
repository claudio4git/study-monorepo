describe("Should validate ways to get propeties from env", () => {
  it("Shoul get env from cypress.config.fs file", () => {
    const helloCypressConfigFile = Cypress.env(
      "CYPRESS_ENV_VARIABLE_CYPRESS_CONFIG_FILE"
    );

    expect(helloCypressConfigFile).to.equal("hello cypress.config.fs file");
  });

  it("Shoul get env from cypress.env.json file", () => {
    const helloCypressEnvFile = Cypress.env(
      "CYPRESS_ENV_VARIABLE_CYPRESS_ENV_FILE"
    );

    expect(helloCypressEnvFile).to.equal("hello cypress.env.json file");
  });

  it("Shoul get env from cypress open command", () => {
    const helloCypressOpenCommand = Cypress.env(
      "CYPRESS_ENV_VARIABLE_CYPRESS_OPEN_COMMAND"
    );

    expect(helloCypressOpenCommand).to.equal("hello open command");
  });
});
