from flask import Flask, request, jsonify
from redis import Redis

app = Flask(__name__)
redis = Redis("redis")

@app.route('/')
def info():
    return "Demo for Service Discovery"

@app.route('/scores', methods=['POST'])
def score():
    json = request.get_json()
    redis.set(json['name'], json['score'])
    return 'CREATED', 201

@app.route('/scores/<name>', methods=['GET'])
def get_score(name):
    value = redis.get(name);
    if not value:
        return 'NOT FOUND', 404
    ret = { 'name': name, 'score': value }
    return jsonify(ret)
    
if __name__ == '__main__':
    app.run(port=3000, host="0.0.0.0")