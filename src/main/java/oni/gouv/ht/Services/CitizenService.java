package oni.gouv.ht.Services;



import oni.gouv.ht.Models.Response;
import org.springframework.web.bind.annotation.RequestParam;

public interface CitizenService {
    Response getCitizenByPid(String pid);
    Response getImageCitizenByPid(String pid);

    Response getCitizenByCriteria(String GivenName,String Gender,String Surname,String DateOfBirth);
}