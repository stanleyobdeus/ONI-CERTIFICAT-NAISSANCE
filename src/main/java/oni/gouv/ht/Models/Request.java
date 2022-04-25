package oni.gouv.ht.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "request")
@Getter
@Setter
@NoArgsConstructor
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String institution;
    private String App;
    private LocalDateTime createDate;
    private String longitude;
    private String latitude;
    private String agent;
    private String ip;
    private String url;
    private String type_request;
    @Column (columnDefinition = "int default 10",name="amount")
    private double amount;
}
