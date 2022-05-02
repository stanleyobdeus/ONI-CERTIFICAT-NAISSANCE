package dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oni.gouv.ht.Bean.ApplicationBean;
import oni.gouv.ht.Models.Application;
import oni.gouv.ht.Models.Institution;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class InstitutionDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ApplicationDto> applicationDtoList;

   /* ModelMapper modelMapper;

    {
        modelMapper = new ModelMapper();
        applicationDtoList = new ArrayList<>();
    }*/

    public InstitutionDto(String name, Long id) {
        this.name = name;
        this.id = id;
    }


    public InstitutionDto(Institution institution) {
        this.name = institution.getName();
        this.id = institution.getId();
        this.slogan = institution.getSlogan();
        this.email = institution.getEmail();
        this.address = institution.getAddress();
        this.telephone = institution.getTelephone();
        this.telephone1 = institution.getTelephone1();
        this.city = institution.getCity();
        this.country = institution.getCountry();
        this.state = institution.getState();
        this.code_postal = institution.getCode_postal();
        this.creataDate = institution.getCreataDate();
        this.createBy = institution.getCreateBy();
        this.enabled = institution.isEnabled();

     /*   institution.setImages(null);

        for (Application application : institution.apps) {
            this.applicationDtoList.add(modelMapper.map(application, ApplicationDto.class));
        }
        this.applicationDtoList = modelMapper.map(institution.getApps(), ArrayList.class);*/
    }
}
