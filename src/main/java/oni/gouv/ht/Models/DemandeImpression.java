package oni.gouv.ht.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oni.gouv.ht.Utils.Status;
import oni.gouv.ht.Utils.TypeDemande;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DemandeImpression {

    private String numeroDemande; //cle primaire
    private String firstNameChild;
    private String lastNameChild;
    private String sexeChild;
    private String dobChild;
    private String ninMother;
    private Status status;
    private LocalDateTime DateDemande;
    private TypeDemande typeDemande;
    private String LieuDimpression;
    private String email;
    private String telephone;

    private TraitementImpression traitementImpressionl;

    private List<Documents> documents;


}
