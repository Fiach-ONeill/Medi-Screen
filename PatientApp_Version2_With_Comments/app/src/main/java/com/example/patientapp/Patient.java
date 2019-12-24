/* Author: Mantvydas Luksas
Student ID: R00150390
 */

/* This class stores all the patient information. Objects created by this class will be sent to
the database containing the values stored in this object class.
 */
package com.example.patientapp;


public class Patient {

        private String firstName;

        private String lastName;

        private String email;

        private String medicName;

        private String medicCode;

        private String medicPhone;

        private String medicEmail;

        private String insuranceName;

        private String insurancePhone;

        private String insuranceEmail;

        private String dateOfBirth;

        private String gender;

        private int age;

        private float cp;

        private float trestbps;

        private float cholesterol;

        private float fbs;

        private float thalach;

        private float exang;

        private float oldpeak;

        private float slope;

        private float ca;

        private int noPregnancies;

        private float glucose;

        private float bloodPressure;

        private float skinThickness;

        private float insulin;

        private float bmi;

        private float diabetesPedigree;

        private float meanRadius;

        private float meanTexture;

        private float meanPerimeter;

        private float restecg;

        private float meanArea;

        private float meanSmoothness;

        private String password;

    public Patient() {



    }

    public Patient(String firstName, String lastName, String email, String medicName, String medicCode, String password,

                   String medicPhone, String medicEmail, String insuranceName, String insurancePhone, String insuranceEmail, String dateOfBirth, String sex, int age, float restecg,

                   float slope, float ca, int noPregnancies, float glucose, float bloodPressure, float skinThickness,

                   float insulin, float bmi, float diabetesPedigree, float meanRadius, float meanTexture,

                   float meanPerimeter, float meanArea, float meanSmoothness) {

        this.firstName = firstName;

        this.lastName = lastName;

        this.restecg = restecg;

        this.age = age;

        this.email = email;

        this.medicName = medicName;

        this.password = password;

        this.medicCode = medicCode;

        this.medicPhone = medicPhone;

        this.insuranceName = insuranceName;

        this.insurancePhone = insurancePhone;

        this.dateOfBirth = dateOfBirth;

        this.gender = sex;

        this.cp = cp;

        this.trestbps = trestbps;

        this.cholesterol = cholesterol;

        this.fbs = fbs;

        this.thalach = thalach;

        this.exang = exang;

        this.oldpeak = oldpeak;

        this.slope = slope;

        this.ca = ca;

        this.noPregnancies = noPregnancies;

        this.glucose = glucose;

        this.bloodPressure = bloodPressure;

        this.skinThickness = skinThickness;

        this.insulin = insulin;

        this.bmi = bmi;

        this.diabetesPedigree = diabetesPedigree;

        this.meanRadius = meanRadius;

        this.meanTexture = meanTexture;

        this.meanPerimeter = meanPerimeter;

        this.meanArea = meanArea;

        this.meanSmoothness = meanSmoothness;

        this.medicEmail = medicEmail;

        this.insuranceEmail = insuranceEmail;

        this.email = email;

        this.password = password;

    }

        public String getPassword(){

        return this.password;

        }

        public void setPassword(String password){

        this.password = password;
        }

        public String getMedicEmail(){

        return this.medicEmail;

        }

        public String getInsuranceEmail(){

        return this.insuranceEmail;

        }

        public void setMedicEmail(String medicEmail){

        this.medicEmail = medicEmail;

        }

        public void setInsuranceEmail(String insuranceEmail){

        this.insuranceEmail = insuranceEmail;
        }

        public void setRestecg(float restecg){

        this.restecg = restecg;

        }

        public float getRestecg(){

        return this.restecg;

        }

        public void setAge(int age){

        this.age = age;

        }

        public int getAge(){

        return this.age;
        }

        public String getFirstName() {

            return firstName;

        }

        public String getLastName() {

            return lastName;

        }


        public String getEmail() {

            return email;

        }

        public String getMedicName() {

            return medicName;

        }

        public String getMedicCode() {

            return medicCode;

        }


        public String getMedicPhone() {

            return medicPhone;

        }

        public String getInsuranceName() {

            return insuranceName;

        }

        public String getInsurancePhone() {

            return insurancePhone;

        }

        public String getDateOfBirth() {

            return dateOfBirth;

        }

        public String getGender() {

            return gender;

        }



        public float getCp() {

            return cp;

        }



        public float getTrestbps() {

            return trestbps;

        }



        public float getCholesterol() {

            return cholesterol;

        }



        public float getFbs() {

            return fbs;

        }



        public float getThalach() {

            return thalach;

        }



        public float getExang() {

            return exang;

        }



        public float getOldpeak() {

            return oldpeak;

        }



        public float getSlope() {

            return slope;

        }



        public float getCa() {

            return ca;

        }



        public int getNoPregnancies() {

            return noPregnancies;

        }



        public float getGlucose() {

            return glucose;

        }



        public float getBloodPressure() {

            return bloodPressure;

        }



        public float getSkinThickness() {

            return skinThickness;

        }



        public float getInsulin() {

            return insulin;

        }



        public float getBmi() {

            return bmi;

        }



        public float getDiabetesPedigree() {

            return diabetesPedigree;

        }



        public float getMeanRadius() {

            return meanRadius;

        }



        public float getMeanTexture() {

            return meanTexture;

        }



        public float getMeanPerimeter() {

            return meanPerimeter;

        }



        public float getMeanArea() {

            return meanArea;

        }



        public float getMeanSmoothness() {

            return meanSmoothness;

        }

        public void setFirstName(String firstName) {

            this.firstName = firstName;

        }

        public void setLastName(String lastName) {

            this.lastName = lastName;

        }

        public void setEmail(String email) {

            this.email = email;

        }

        public void setMedicName(String medicName) { this.medicName = medicName; }

        public void setMedicCode(String medicCode) {

            this.medicCode = medicCode;

        }

        public void setMedicPhone(String medicPhone) {

            this.medicPhone = medicPhone;

        }

        public void setInsuranceName(String insuranceName) {

            this.insuranceName = insuranceName;

        }

        public void setInsurancePhone(String insurancePhone) {

            this.insurancePhone = insurancePhone;

        }


        public void setDateOfBirth(String dateOfBirth) {

            this.dateOfBirth = dateOfBirth;

        }

        public void setGender(String gender) {

            this.gender = gender;

        }

        public void setCp(float cp) {

            this.cp = cp;

        }

        public void setTrestbps(float trestbps) {

            this.trestbps = trestbps;

        }

        public void setCholesterol(float cholesterol) {

            this.cholesterol = cholesterol;

        }

        public void setFbs(float fbs) {

            this.fbs = fbs;

        }

        public void setThalach(float thalach) {

            this.thalach = thalach;

        }

        public void setExang(float exang) {

            this.exang = exang;

        }

        public void setOldpeak(float oldpeak) {

            this.oldpeak = oldpeak;

        }

        public void setSlope(float slope) {

            this.slope = slope;

        }

        public void setCa(float ca) {

            this.ca = ca;

        }

        public void setNoPregnancies(int noPregnancies) {

            this.noPregnancies = noPregnancies;

        }

        public void setGlucose(float glucose) {

            this.glucose = glucose;

        }

        public void setBloodPressure(float bloodPressure) {

            this.bloodPressure = bloodPressure;

        }

        public void setSkinThickness(float skinThickness) {

            this.skinThickness = skinThickness;

        }

        public void setInsulin(float insulin) {

            this.insulin = insulin;

        }

        public void setBmi(float bmi) {

            this.bmi = bmi;

        }

        public void setDiabetesPedigree(float diabetesPedigree) {

            this.diabetesPedigree = diabetesPedigree;

        }

        public void setMeanRadius(float meanRadius) {

            this.meanRadius = meanRadius;

        }

        public void setMeanTexture(float meanTexture) {

            this.meanTexture = meanTexture;

        }

        public void setMeanPerimeter(float meanPerimeter) {

            this.meanPerimeter = meanPerimeter;

        }

        public void setMeanArea(float meanArea) {

            this.meanArea = meanArea;

        }

        public void setMeanSmoothness(float meanSmoothness) {

            this.meanSmoothness = meanSmoothness;

        }


    }




