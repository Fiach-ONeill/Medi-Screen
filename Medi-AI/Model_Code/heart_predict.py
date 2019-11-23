import pandas as pd
import numpy as np
from sklearn import model_selection,metrics
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import classification_report, accuracy_score
import pickle

cardio = pd.read_csv("heartplay.csv")

cardio.dropna(axis="columns")
X = cardio.drop('target',axis=1).values
y = cardio['target'].values

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=0)

clf = RandomForestClassifier(n_jobs=2,random_state=0)

clf.fit(X_train,y_train)
y_pred = clf.predict(X_test)

print("Accuracy:",metrics.accuracy_score(y_test, y_pred))

print('Dumping to pickle file')
file_name = 'heart_predict.pkl'
with open(file_name,'wb') as f:
    pickle.dump(clf,f)
