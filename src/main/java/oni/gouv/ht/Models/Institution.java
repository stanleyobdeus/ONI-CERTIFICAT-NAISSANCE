package oni.gouv.ht.Models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "institution")
@Getter
@Setter
@NoArgsConstructor
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String slogan;
    private String email;
    private String address;
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



    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_image", nullable = true)
    private Images images;

    @OneToMany(mappedBy= "ins")
    public List<Application> apps;

    public Institution(Long id, String name, List<Application> apps) {
        this.id = id;
        this.name = name;
        this.apps = apps;
    }



    public Institution(String name, String slogan, String e ) {
        this.name = name;
        this.slogan = slogan;
        email = e;
    }
}
