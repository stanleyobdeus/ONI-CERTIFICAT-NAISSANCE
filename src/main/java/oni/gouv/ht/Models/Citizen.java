package oni.gouv.ht.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Citizen implements Serializable {

    @JsonProperty("PID")
    private String PID;
    @JsonProperty("OldNIN")
    private String OldNIN;
    @JsonProperty("FirstName")
    private String FirstName;
    @JsonProperty("MiddleName")
    private String MiddleName;
    @JsonProperty("LastName")
    private String LastName;
    @JsonProperty("Gender")
    private String Gender;
    @JsonProperty("ResidenceCodLoc")
    private String ResidenceCodLoc;
    @JsonProperty("ResidenceAddress")
    private String ResidenceAddress;
    @JsonProperty("DateOfBirth")
    private String DateOfBirth;
    @JsonProperty("CountryOfBirth")
    private String CountryOfBirth;
    @JsonProperty("DepartmentOfBirth")
    private String DepartmentOfBirth;
    @JsonProperty("CommuneOfBirth")
    private String CommuneOfBirth;
    @JsonProperty("PlaceOfBirthAbroad")
    private String PlaceOfBirthAbroad;
    @JsonProperty("PhoneNumber")
    private String PhoneNumber;
    @JsonProperty("DocNo")
    private List<String> DocNo;

    public Citizen(String PID, String oldNIN, String firstName, String middleName, String lastName, String gender, String residenceCodLoc, String residenceAddress, String dateOfBirth, String countryOfBirth, String departmentOfBirth, String communeOfBirth, String placeOfBirthAbroad, String phoneNumber, List<String> docNo) {
        this.PID = PID;
        OldNIN = oldNIN;
        FirstName = firstName;
        MiddleName = middleName;
        LastName = lastName;
        Gender = gender;
        ResidenceCodLoc = residenceCodLoc;
        ResidenceAddress = residenceAddress;
        DateOfBirth = dateOfBirth;
        CountryOfBirth = countryOfBirth;
        DepartmentOfBirth = departmentOfBirth;
        CommuneOfBirth = communeOfBirth;
        PlaceOfBirthAbroad = placeOfBirthAbroad;
        PhoneNumber = phoneNumber;
        DocNo = docNo;
    }
}
