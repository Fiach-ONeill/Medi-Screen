import os
from flask import Flask
import tensorflow as tf
import keras
from keras import backend as K
from tensorflow.python.keras.models import load_model
import numpy as np
from flask import Flask, jsonify, request
from flask_restful import Resource, Api
import pickle

#flask run --without-threads

os.environ["CUDA_DEVICE_ORDER"] = "PCI_BUS_ID"
os.environ["CUDA_VISIBLE_DEVICES"] = "-1"#Set tf/keras computation settings to CPU

#Error messages if call is illegal
ERROR_MSG_0 = "ERROR_0: Please enter a valid disease(diabetes,breast_cancer or heart_disease)"
ERROR_MSG_0 = "ERROR_1: Ensure that the data you have sent is of the right shape/type"

#Before prediction
K.clear_session()

app = Flask(__name__)
api = Api(app)
model = "" #to be set later

def getModel(m):
    res = None
    if m=="diabetes":
        res= load_model(m+".h5")#h5 is the file extension
    elif m=="breast_cancer":
        res = pickle.load(open(m+".pkl",'rb'))
    else:
        res = ERROR_MSG_0
    return res

graph = tf.get_default_graph()#For the tensor error
@app.route("/",methods=["GET","POST"])

def predict():
    result = {}
    global model
    model_type = request.json['model_type']

    data = request.json['data']
    data = [float(i) for i in data]#convert every item from string to float for computation
    data = np.array([data])#for tensor operations/Sklearn

    model = getModel(model_type)#set model type, see above
    print(model)
    if model==ERROR_MSG_0:
        result = {"ERROR_MSG_0": ERROR_MSG_0}
    elif model=="diabetes.h5":#for Deep Learning model
        global graph
        with graph.as_default():
            prediction = model.predict(data,batch_size=None)
            prediction = prediction.tolist()#numpy objects can't be parsed via JSON format
            result = {"outcome":prediction}
            #After prediction
            K.clear_session()#another attempt for the tensor error
    else:
        prediction = model.predict(data) #for non-Deep Learning models
        prediction = prediction.tolist()
        accuracy = model.predict_proba(data)
        accuracy = accuracy.tolist()
        result = {"outcome":prediction,"accuracy":accuracy}
    return jsonify(result)#convert to json to send back to user


if __name__ == "__main__":
    print("Loading Model")
    app.run()
