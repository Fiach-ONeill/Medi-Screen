import os
from flask import Flask
import tensorflow as tf
import keras
from tensorflow.python.keras.models import load_model
import numpy as np
from flask import Flask, jsonify, request
from flask_restful import Resource, Api

os.environ["CUDA_DEVICE_ORDER"] = "PCI_BUS_ID"
os.environ["CUDA_VISIBLE_DEVICES"] = "-1"#Set tf/keras computation settings to CPU

app = Flask(__name__)
api = Api(app)
model = "" #to be set later

def getModel(m):
    res= load_model(m+".h5")#h5 is the file extension
    return res #this returns the weights and architecture of the network
    #load_model builds the model


@app.route("/",methods=["GET","POST"])

def predict():
    global model
    model_type = request.json['model_type']
    data = request.json['data']
    data = [float(i) for i in data]#convert every item from string to float
    data = np.array([data])
    model = getModel(model_type)#set model type, see above
    prediction = model.predict(data,batch_size=None)
    prediction = prediction.tolist();
    result = {"outcome":prediction}
    return jsonify(result)#convert to json to send back to user


if __name__ == "__main__":
    print("Loading Model")
    app.run()
