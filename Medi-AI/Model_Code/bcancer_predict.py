import numpy as np
import pandas as pd

from sklearn.model_selection import KFold
from sklearn.preprocessing import MinMaxScaler
from sklearn.svm import SVR
from sklearn.naive_bayes import GaussianNB
from sklearn.externals import joblib

bc = pd.read_csv('Breast_cancer_data.csv')
bc.dropna(axis='columns')#drop empty columns

X = bc.drop('diagnosis',axis=1)#seperate features & labels
y = bc['diagnosis']

scaler = MinMaxScaler(feature_range=(0,1))
X = scaler.fit_transform(X)#scale data

nb = GaussianNB()#Gaussian model of the naieve bayes classifier

scores = []#from training accuracy

#implement K-fold cross validation
cross_val = KFold(n_splits=10, random_state=20, shuffle=True)
for train_index, test_index in cross_val.split(X):
  print("Train Index: ", train_index, "\n")
  print("Test Index: ", test_index)

  X_train, X_test, y_train, y_test = X[train_index],X[test_index],y[train_index],y[test_index]
  nb.fit(X_train, y_train)
  print("Trainin...please wait...")
  scores.append(nb.score(X_test,y_test))


print("""
****************
Final Score:
""")
print(np.mean(scores))
print("\n")
print("Saving to pickle file")
joblib.dump(nb, 'breast_cancer.pkl')
print("Saved")
