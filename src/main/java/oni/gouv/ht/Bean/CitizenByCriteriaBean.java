package oni.gouv.ht.Bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CitizenByCriteriaBean {
    @JsonProperty("PID")
    private String pid;
    @JsonProperty("DateOfBirth")
    private String dateOfBirth;
    @JsonProperty("GivenName")
    private String givenName;
    @JsonProperty("Surname")
    private String surname;
    @JsonProperty("Gender")
    private String gender;
    @JsonProperty("Nationality")
    private String nationality;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
