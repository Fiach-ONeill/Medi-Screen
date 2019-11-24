package edu.cit.mediscreen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.Date;

@Document(collection = "medics")
public class Medic {

    private static final String firstNameRegexp = "[A-ZÄÖÜ][a-zäöüß]+";
    private static final String lastNameRegexp = "[A-ZÄÖÜ][a-zäöüß]+([ '-][A-ZÄÖÜ][a-zäöüß]+)*";

    @JsonIgnore
    @Version
    private Long version;

    @JsonIgnore
    @Id
    private String id;

    @JsonIgnore
    @CreatedDate
    private Date createdDate;

    @Pattern(regexp = firstNameRegexp, message = "{medic.firstName.pattern}")
    @Size(min = 2, max = 30)
    @NotEmpty(message = "{medic.firstName.notEmpty}")
    private String firstName;

    @Pattern(regexp = lastNameRegexp, message = "{medic.lastName.pattern}")
    @Size(min = 2, max = 30)
    @NotEmpty(message = "{medic.lastName.notEmpty}")
    private String lastName;

    @Email(message = "{medic.email.pattern}")
    @NotEmpty(message = "{medic.email.notEmpty}")
    private String email;

    private String patientCode;


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
    public String getPatientCode() {
        return patientCode;
    }


    public void setCreatedDate() {
        this.createdDate = new Date();
    }
    public void setCreatedDate(Date date) {
        this.createdDate = date;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmail(String eMail) {
        this.email = eMail;
    }
    public void setPatientCode() {
        this.patientCode = this.lastName + this.firstName.charAt(0) + Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + Calendar.getInstance().get(Calendar.MILLISECOND);
    }
    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode;
    }


    public Medic() {
    }

    public Medic(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
