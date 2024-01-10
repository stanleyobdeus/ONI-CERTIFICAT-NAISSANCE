package oni.gouv.ht.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActDeNaissanceDto {

    private String firstNameChild;
    private String lastNameChild;
    private String sexeChild;
    private String dobChild;
    private String timeOfBirthChild;
    private String ninChild;


    private String firstNameMother;
    private String lastNameMother;
    private String ninMother;
    private String NationalityMother;


    private String firstNameFather;
    private String lastNameFather;
    private String ninFather;
    private String NationalityFather;

    private String temoins;

    private String chilGuardian;

    private byte[] documentNumber;

    private byte[] certificateContent;




}
