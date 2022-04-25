package oni.gouv.ht.Utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class BuildHeaderRequestDermalog {
    @Value("${oni.gouv.app.dermalogToken}")
    private String jwtTokenDermalog;

    public  HttpEntity<String> Build(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer " +jwtTokenDermalog);
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        return httpEntity;
    }
}
