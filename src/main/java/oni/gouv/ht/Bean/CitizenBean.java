package oni.gouv.ht.Bean;

import java.util.List;

public class CitizenBean {

    private String PID;
    private String OldNIN;
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String Gender;
    private String ResidenceCodLoc;
    private String ResidenceAddress;
    private String DateOfBirth;
    private String CountryOfBirth;
    private String DepartmentOfBirth;
    private String CommuneOfBirth;
    private String PlaceOfBirthAbroad;
    private String PhoneNumber;
    private List<String> DocNo;



    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getOldNIN() {
        return OldNIN;
    }

    public void setOldNIN(String oldNIN) {
        OldNIN = oldNIN;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getResidenceCodLoc() {
        return ResidenceCodLoc;
    }

    public void setResidenceCodLoc(String residenceCodLoc) {
        ResidenceCodLoc = residenceCodLoc;
    }

    public String getResidenceAddress() {
        return ResidenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        ResidenceAddress = residenceAddress;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getCountryOfBirth() {
        return CountryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        CountryOfBirth = countryOfBirth;
    }

    public String getDepartmentOfBirth() {
        return DepartmentOfBirth;
    }

    public void setDepartmentOfBirth(String departmentOfBirth) {
        DepartmentOfBirth = departmentOfBirth;
    }

    public String getCommuneOfBirth() {
        return CommuneOfBirth;
    }

    public void setCommuneOfBirth(String communeOfBirth) {
        CommuneOfBirth = communeOfBirth;
    }

    public String getPlaceOfBirthAbroad() {
        return PlaceOfBirthAbroad;
    }

    public void setPlaceOfBirthAbroad(String placeOfBirthAbroad) {
        PlaceOfBirthAbroad = placeOfBirthAbroad;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public List<String> getDocNo() {
        return DocNo;
    }

    public void setDocNo(List<String> docNo) {
        DocNo = docNo;
    }
}
