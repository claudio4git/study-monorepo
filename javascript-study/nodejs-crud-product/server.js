const express = require("express");
const mongoose = require("mongoose");
const cors = require("cors")

const requireDir = require("require-dir");

// application prepare
const app = express();
app.use(express.json());
app.use(cors());

// database prepare
mongoose.connect(
    "mongodb://localhost:27017/node_crud_product", 
    {useNewUrlParser: true, useUnifiedTopology: true}
);
requireDir("./src/models");

// routes
app.use("/api", require("./src/routes"));

// application launch
app.listen(3001);