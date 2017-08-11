import json
from flask import Flask, Response, request
from flask_pymongo import PyMongo
app = Flask(__name__)
app.config['MONGO_HOST'] = 'mongo'
app.config['MONGO_PORT'] = 27017
app.config['MONGO_DBNAME'] = 'inventory'
mongo = PyMongo(app)

@app.route("/")
def description():
    return "Products API!"

products = [
    {"id": 1, "name": "Samsung Galaxy S8"},
    {"id": 2, "name": "Apple IPhone 6s"},
    {"id": 3, "name": "Google Nexus 6P"},
    {"id": 4, "name": "LG G6"}
]

@app.route("/products", methods=['GET'])
def list_products():
    products = mongo.db.products.find({"$or": [{"discontinued":{'$exists':False}}, {"discontinued":False}]})
    return Response(json.dumps(products), mimetype='application/json')

@app.route("/products", methods=['POST'])
def add_product():
    prod = request.json
    prod_id = mongo.db.products.insert(prod)
    return Response(response=str(prod_id), status=201)

if __name__ == "__main__":
    app.run(host='0.0.0.0', port=8000)   