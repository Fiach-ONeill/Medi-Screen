package edu.cit.mediscreen.model;

import com.fasterxml.jackson.annotation.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Document(collection = "patients")
public class Patient {

    private static final String firstNameRegexp = "[A-ZÄÖÜ][a-zäöüß]+";
    private static final String lastNameRegexp = "[A-ZÄÖÜ][a-zäöüß]+([ '-][A-ZÄÖÜ][a-zäöüß]+)*";
    private static final String medicCodeRegexp = "[A-ZÄÖÜ][a-zäöüß]+[A-ZÄÖÜ][1-9]{5}";


    @JsonIgnore
    @Version
    private Long version;

    @JsonIgnore
    @Id
    private String id;

    @JsonIgnore
    @CreatedDate
    private Date createdDate;

    @Pattern(regexp = firstNameRegexp, message = "{patient.firstName.pattern}")
    @Size(min = 2, max = 30)
    @NotEmpty(message = "{patient.firstName.notEmpty}")
    private String firstName;

    @Pattern(regexp = lastNameRegexp, message = "{patient.lastName.pattern]")
    @Size(min = 2, max = 30)
    @NotEmpty(message = "{patient.lastName.notEmpty}")
    private String lastName;

    @Email(message = "{patient.email.pattern}")
    @NotEmpty(message = "{patient.email.notEmpty}")
    private String email;

    @Pattern(regexp = medicCodeRegexp, message = "{patient.medicCode.pattern}")
    @NotEmpty(message = "{patient.medicCode.notEmpty}")
    private String medicCode;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Past(message = "{patient.dateOfBirth.past}")

    private LocalDate dateOfBirth;

    @Pattern(regexp = "[MFD]", message = "{patient.sex.pattern}")
    private String sex;

    private float cp;

    private float trestbps;

    private float cholesterol;

    private float fbs;

    private float thalach;

    private float exang;

    private float oldpeak;

    private float slope;

    private float ca;

    @PositiveOrZero
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

    private float meanArea;

    private float meanSmoothness;


    public Long getVersion() {
        return version;
    }

    public String getId() {
        return id;
    }

    public Date getCreatedDate() {
        return createdDate;
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

    public String getMedicCode() {
        return medicCode;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSex() {
        return sex;
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


    public void setVersion(Long version) {
        this.version = version;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setCreatedDate() {
        this.createdDate = new Date();
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

    public void setMedicCode(String medicCode) {
        this.medicCode = medicCode;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dateOfBirth = LocalDate.parse(dateOfBirth, formatter);
    }

    public void setSex(String sex) {
        this.sex = sex;
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


    public Patient() {

    }

    public Patient(String firstName, String lastName, String email, String medicCode, LocalDate dateOfBirth, String sex, float cp, float trestbps, float cholesterol, float fbs, float thalach, float exang, float oldpeak, float slope, float ca, int noPregnancies, float glucose, float bloodPressure, float skinThickness, float insulin, float bmi, float diabetesPedigree, float meanRadius, float meanTexture, float meanPerimeter, float meanArea, float meanSmoothness) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.medicCode = medicCode;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
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
    }
}
