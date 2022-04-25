package oni.gouv.ht.Interface;


import oni.gouv.ht.Bean.ImagesBean;
import oni.gouv.ht.Bean.InstitutionBean;
import oni.gouv.ht.Bean.UserBean;
import oni.gouv.ht.Exception.AlreadyExistdException;
import oni.gouv.ht.Exception.NotFoundException;
import oni.gouv.ht.Models.Institution;
import oni.gouv.ht.Models.Response;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IInstitutionService {

    InstitutionBean CreateInstitution(InstitutionBean institutionBean, MultipartFile file) throws AlreadyExistdException, IOException;

    List<InstitutionBean> FindAllInsttitution();

    String UpdateInstitution(InstitutionBean organisationBean) throws NotFoundException, AlreadyExistdException;

    InstitutionBean FinddInstitutionById(String id) throws NotFoundException;

    InstitutionBean FinddInstitutionByName(String name) throws NotFoundException;

    Response lockOrUnlockOrganisation(Long id_organisation, Long updateBy, boolean enable)throws NotFoundException;


    Institution createInsTest();
}