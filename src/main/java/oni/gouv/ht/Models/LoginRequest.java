package oni.gouv.ht.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {
    private String username;
    private String password;
    private String id_organisation;
    private String ip;
    private String os;
    private String browser;
    private String longitude;
    private String latitude;


    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;

    }

}
