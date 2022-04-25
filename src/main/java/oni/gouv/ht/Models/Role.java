package oni.gouv.ht.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20)
    private String name;

    @Column(length = 500)
    private String description ;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;


    public Role(Integer id) {
        this.id=id;
    }

}
