package oni.gouv.ht.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrintActDeNaissance {

    private int printBy;
    private String documentNumber;
    private String numeroDemande;
    private int numberOfTimes;
}
