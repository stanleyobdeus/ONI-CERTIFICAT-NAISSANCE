package oni.gouv.ht.Bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oni.gouv.ht.Models.Images;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class InstitutionBean {

    private Long id;
    private String name;
    private String slogan;
    private String email;
    private String address;
    private String address1;
    private String telephone;
    private String telephone1;
    private String city;
    private String country;
    private String state;
    private String code_postal;
    private LocalDateTime creataDate;
    private LocalDateTime updateDate;
    private Long createBy;
    private Long updateBy;
    private boolean enabled;

    private Images images;
}
