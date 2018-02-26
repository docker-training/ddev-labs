from flask import Flask
app = Flask(__name__)

healthy = True

@app.route("/")
def description():
    return "API with health check"

@app.route("/health", methods=['GET'])
def get_health():
    if healthy == True:
        return 'OK', 200
    return 'NOT OK', 500

@app.route("/health/<status>", methods=['POST'])
def set_health(status):
    global healthy
    if status.lower() == "good":
        healthy = True;
    else:
        healthy = False;
    return 'OK', 200
    
if __name__ == "__main__":
    app.run(host='0.0.0.0', port=8000)   