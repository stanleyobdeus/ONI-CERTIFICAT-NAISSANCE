package oni.gouv.ht.Bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApplicationBean {
    private String name;
    private String origin;
    private boolean strict;
    private Double request_price;
    private String id_institution;
}
