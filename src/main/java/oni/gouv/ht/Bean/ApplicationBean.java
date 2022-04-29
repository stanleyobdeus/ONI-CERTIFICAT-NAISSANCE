package oni.gouv.ht.Bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ApplicationBean {
    private String name;
    private String origin;
    private boolean strict;
    private Double request_price;
    private String id_institution;
    private Long id;
    private String secret_key;
    private String public_key;
    private LocalDateTime create_date;
    private int lock;
    private String lock_message;

}
