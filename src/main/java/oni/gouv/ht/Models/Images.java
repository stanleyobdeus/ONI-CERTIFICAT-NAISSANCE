package oni.gouv.ht.Models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(	name = "image")
@Getter
@Setter
@NoArgsConstructor
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "filname")
    private String filname;

    @Column(name = "type")
    private String type;

    @Column(name = "filesize")
    private Long file_size;

    @Column(name = "contentype")
    private String contentype;

   /* @OneToOne(mappedBy = "images", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Operator operator;*/



    public Images(String originalFilename, byte[] bytes, String contentType, String size, String type) {
        this.filname=originalFilename;
        this.image=bytes;
        this.contentype=contentType;
        this.file_size=Long.valueOf(size);
        this.type=type;

    }

    public Images(byte[] bytes) {
        this.image=bytes;
    }

}
