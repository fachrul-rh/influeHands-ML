import json
from typing import Dict

import numpy as np
import tensorflow as tf
import pandas as pd
from flask import Flask, jsonify, request

dataset = pd.read_csv("https://raw.githubusercontent.com/fachrul-rh/influeHands-ML/main/Dataset/TikTok.csv")
app = Flask(__name__)
data = np.load("tiktok.npy")
tiktok_name = dataset.loc[: , "Username Tiktok"]

def prediction(input: np.array) -> Dict:
    output = input[None] @ data
    output = tf.constant(output)
    output = output / tf.reduce_sum(output, axis=1, keepdims=True)
    top_5 = tf.nn.top_k(output, k=5)[1][0]
    result = [tiktok_name[int(index)] for index in top_5]
    return {"result" : result}

def convert_json_to_np(input: Dict) -> np.array:
    keys = ["Food & Cooking", "Fashion", "Entertainment", "Travel & Accomodation", "Beauty", "Healthcare", "Technology", "Automotive", "Education", "Sports", "Finance", "Tips & Trick About Career"]
    result = []
    for key in keys:
        result.append(input.get(key))
    return np.array(result)
    
    
@app.route("/", methods=["GET", "POST"])
def main():
    if request.method == "POST":
        if request.json is None:
            return jsonify({"error" : "no data"})
        
        try:
            input =  request.get_json()
            input = convert_json_to_np(input)
            result = prediction(input)
            result = json.dumps(result)
            return result
        except Exception as e:
            return jsonify({"error": str(e)})
        
    return "OK"


if __name__ == "__main__":
    app.run(debug=True)
