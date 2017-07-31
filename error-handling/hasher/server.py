from flask import Flask, Response
import random
import uuid

app = Flask(__name__)

@app.route("/hash")
def get_hash():
    value = random.randint(0, 9)
    if value < 8:
        return Response(status=500)
    hash_value = uuid.uuid4().hex
    return Response(hash_value)

if __name__ == "__main__":
    app.run(host='0.0.0.0', port=8000)