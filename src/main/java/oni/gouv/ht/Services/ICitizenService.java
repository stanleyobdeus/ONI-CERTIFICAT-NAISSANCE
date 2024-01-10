package oni.gouv.ht.Services;



import oni.gouv.ht.Models.Response;

public interface ICitizenService {
    Response getCitizenByPid(String pid);
    Response getImageCitizenByPid(String pid);

    Response getCitizenByCriteria(String GivenName,String Gender,String Surname,String DateOfBirth);
}