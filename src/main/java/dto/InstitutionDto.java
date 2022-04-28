package dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class InstitutionDto {

    private String name;
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String slogan;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String address;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String telephone;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String telephone1;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String city;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String country;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String state;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String code_postal;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime creataDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long createBy;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean enabled;


    public InstitutionDto(String name, Long id) {
        this.name = name;
        this.id = id;
    }


    public InstitutionDto(String name, Long id, String slogan, String email, String address, String telephone, String telephone1, String city, String country, String state, String code_postal, LocalDateTime creataDate, Long createBy, boolean enabled) {
        this.name = name;
        this.id = id;
        this.slogan = slogan;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
        this.telephone1 = telephone1;
        this.city = city;
        this.country = country;
        this.state = state;
        this.code_postal = code_postal;
        this.creataDate = creataDate;
        this.createBy = createBy;
        this.enabled = enabled;
    }
}
