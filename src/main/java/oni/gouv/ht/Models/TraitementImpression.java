package oni.gouv.ht.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TraitementImpression {
    private String traiterBy;
    private LocalDateTime dateTraitement;
    private LocalDateTime decission;
    private boolean approuve;
    private String note;

}
