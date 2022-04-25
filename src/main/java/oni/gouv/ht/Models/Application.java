package oni.gouv.ht.Models;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String secret_key;
    private String public_key;
    @Column(nullable = true)
    private String origin;

    private LocalDateTime create_date;

    @Column(name="lock",columnDefinition = "int default 0")
    private int lock;

    private String lock_message;

    @Column(name="strict",columnDefinition = "int default 1")
    private int strict;

    @Column( name="request_price",columnDefinition = "int default 10")
    private Double request_price;

    @ManyToOne()
    private Institution ins;

    public Application(String s, String s1, String def) {
        name = s;
        secret_key = s1;
        public_key = def;

    }
}
