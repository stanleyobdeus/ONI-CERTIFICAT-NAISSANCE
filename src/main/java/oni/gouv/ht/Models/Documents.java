package oni.gouv.ht.Models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oni.gouv.ht.Utils.TypeDocument;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Documents {
   private TypeDocument typeDocument;
   private byte [] document;
   private String nameDocument;

}
