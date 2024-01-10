package oni.gouv.ht.Services;


import oni.gouv.ht.Models.Citizen;
import oni.gouv.ht.Models.Response;
import oni.gouv.ht.Utils.Constante;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CitizenServiceImpl implements ICitizenService {

    RestTemplate restTemplate = new RestTemplate();


    @Override
    public Response getCitizenByPid(String pid) {
        ResponseEntity<Citizen> responseEntity = null;
        responseEntity = restTemplate.exchange(Constante.URL_GET_CITOYEN + "/" + pid, HttpMethod.GET, null, Citizen.class);        return null;
    }

    @Override
    public Response getImageCitizenByPid(String pid) {
        ResponseEntity<Citizen> responseEntity = null;
        responseEntity = restTemplate.exchange(Constante.URL_GET_CITOYEN + "/" + pid, HttpMethod.GET, null, Citizen.class);
         return null;
    }

    @Override
    public Response getCitizenByCriteria(String GivenName, String Gender, String Surname, String DateOfBirth) {
        return null;
    }




}
