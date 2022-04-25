package oni.gouv.ht.Services;


import oni.gouv.ht.Bean.InstitutionBean;
import oni.gouv.ht.Exception.AlreadyExistdException;
import oni.gouv.ht.Exception.NotFoundException;
import oni.gouv.ht.Interface.IInstitutionService;
import oni.gouv.ht.Models.Images;
import oni.gouv.ht.Models.Institution;
import oni.gouv.ht.Models.Response;
import oni.gouv.ht.Repository.ImageRepository;
import oni.gouv.ht.Repository.InstitutionRepository;
import oni.gouv.ht.Utils.Constant;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InstitutionServiceImpl implements IInstitutionService {

    @Autowired
    InstitutionRepository institutionRepository;



    ModelMapper modelMapper;
    @Autowired
    ImageRepository imageRepository;


    {
        modelMapper = new ModelMapper();
    }

    @Override
    public InstitutionBean CreateInstitution(InstitutionBean institutionBean, MultipartFile file) throws AlreadyExistdException, IOException {

        if (institutionRepository.getInstitutionByName(institutionBean.getName()) != null) {
            throw new AlreadyExistdException(Constant.ORGANISATION_ALREADY_EXIST);
        }

        //save image institution
        Images images = new Images(file.getOriginalFilename(), file.getBytes(), file.getContentType(), String.valueOf(file.getSize()), file.getName());
        Images images1 = imageRepository.save(images);

        //save institution
        modelMapper = new ModelMapper();
        Institution institution = modelMapper.map(institutionBean, Institution.class);
        institution.setCreataDate(LocalDateTime.now());
        institution.setImages(images1);
        institution.setEnabled(true);
        institution.setName(institutionBean.getName());
        institution.setAddress(institutionBean.getAddress());
        institution.setCity(institutionBean.getCity());
        institution.setCountry(institutionBean.getCountry());
        institution.setEmail(institutionBean.getEmail());
        institution.setSlogan(institutionBean.getSlogan());
        institution.setTelephone(institutionBean.getTelephone());
        institution.setCreateBy(Long.valueOf("1"));

        Institution entityInstitution = institutionRepository.save(institution);

        InstitutionBean beanInstitution = modelMapper.map(entityInstitution, InstitutionBean.class);
        return beanInstitution;
    }

    @Override
    public List<InstitutionBean> FindAllInsttitution() {
        return null;
    }

    @Override
    public String UpdateInstitution(InstitutionBean organisationBean) throws NotFoundException, AlreadyExistdException {
        return null;
    }

    @Override
    public InstitutionBean FinddInstitutionById(String id) throws NotFoundException {
        return null;
    }

    @Override
    public InstitutionBean FinddInstitutionByName(String name) throws NotFoundException {
        return null;
    }

    @Override
    public Response lockOrUnlockOrganisation(Long id_organisation, Long updateBy, boolean enable) throws NotFoundException {
        return null;
    }

    @Override
    public Institution createInsTest() {
        long s = institutionRepository.count();
        String c ="";
        if(s>0) {
            c="_"+s;
        }
        Institution i = new Institution("DGI"+c, "TEST", "t@gm.com");
        Images images = new Images("test.png",null, "PNG","1233","test");
        Images images1 = imageRepository.save(images);
        i.setImages(images1);
        return  institutionRepository.save(i);
    }
}