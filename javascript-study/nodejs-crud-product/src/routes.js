const express = require("express");
const routes = express.Router();

const ProductController = require("./constrollers/ProductController")

routes.get("/", (req, res) => res.send("Crud product project"));
routes.get("/products", ProductController.list);
routes.get("/products/:id", ProductController.show);
routes.post("/products", ProductController.create);
routes.put("/products/:id", ProductController.update);
routes.delete("/products/:id", ProductController.delete);

module.exports = routes;