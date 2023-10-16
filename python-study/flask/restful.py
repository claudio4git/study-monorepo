import os

from flask import Flask, request, jsonify
from flask_marshmallow import Marshmallow
from flask_sqlalchemy import SQLAlchemy

# Init app
app = Flask(__name__)
basedir = os.path.abspath(os.path.dirname(__file__))

# Database
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///' + os.path.join(basedir, 'db.sqlite')
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False

# Init database
db = SQLAlchemy(app)

# Init marshmallow
ma = Marshmallow(app)


# Product model
class Product(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(100))
    price = db.Column(db.Float)
    quantity = db.Column(db.Integer)

    def __init__(self, name, price, quantity):
        self.name = name
        self.price = price
        self.quantity = quantity


# Product schema
class ProductSchema(ma.ModelSchema):
    class Meta:
        fields = ('id', 'name', 'price', 'quantity')


# Init schema
product_schema = ProductSchema(strict=True)
products_schema = ProductSchema(many=True, strict=True)


# Endpoint: create a new product
@app.route("/product", methods=['POST'])
def add_product():
    name = request.json['name']
    price = request.json['price']
    quantity = request.json['quantity']

    new_product = Product(name, price, quantity)

    db.session.add(new_product)
    db.session.commit()

    return product_schema.jsonify(new_product)


# Endpoint: get all products
@app.route("/product", methods=['GET'])
def get_all_products():
    all_products = Product.query.all()
    result = products_schema.dump(all_products)
    return jsonify(result.data)


# Endpoint: get a single product
@app.route("/product/<id>", methods=['GET'])
def get_product(id_product):
    product = Product.query.get(id_product)
    return product_schema.jsonify(product)


# Endpoint: update a single product
@app.route("/product/<id>", methods=['PUT'])
def update_product(id_product):
    product = Product.query.get(id_product)

    product.name = request['name']
    product.price = request['price']
    product.quantity = request['quantity']

    db.session.commit()

    return product_schema.jsonify(product)


# Endpoint: delete a single product
@app.route("/product/<id>", methods=['DELETE'])
def delete_product(id_product):
    product = Product.query.get(id_product)

    db.session.delete(product)
    db.session.commit()

    return product_schema.jsonify(product)


@app.route("/")
def home():
    return "Hello world"


# Run Application
if __name__ == '__main__':
    app.run(debug=True)
