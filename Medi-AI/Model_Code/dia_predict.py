import tensorflow as tf
import keras
import numpy as np
import pandas as pd
from sklearn.preprocessing import scale
from sklearn.model_selection import train_test_split
from keras import Sequential
from keras.layers import Dense
from keras.optimizers import Adadelta

db = pd.read_csv('diabetes.csv')#read dataset

X = db.drop('Outcome',axis=1)
y = db['Outcome'] #split labels & features

X = scale(X) #standardize the data

X_train,X_test,y_train,y_test = train_test_split(X,y,test_size=0.3)#split into train & test dataset

model = Sequential()

#Hidden layer 1
model.add(Dense(4,activation='relu',
                    kernel_initializer='random_normal',
                    input_dim=8))
#Hidden layer 2
model.add(Dense(4,activation='relu',
                    kernel_initializer='random_normal'))
#Output layer
model.add(Dense(1, activation='sigmoid',
                    kernel_initializer='random_normal'))

#Compile the DNN
model.compile(optimizer=Adadelta(),
                   loss='binary_crossentropy',
                  metrics=['accuracy'])

model.fit(X_train,y_train, batch_size=10, epochs=100)
eval_model = model.evaluate(X_train,y_train)

y_pred = model.predict(X_test)#Run model inference on test data 
y_pred = (y_pred>0.5)
from keras.models import load_model

model.save('my_model.h5') 
