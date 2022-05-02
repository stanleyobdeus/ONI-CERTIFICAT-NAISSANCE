package oni.gouv.ht.Services;


import dto.InstitutionDto;
import oni.gouv.ht.Bean.InstitutionBean;
import oni.gouv.ht.Exception.AlreadyExistdException;
import oni.gouv.ht.Exception.NotFoundException;
import oni.gouv.ht.Interface.IInstitutionService;
import oni.gouv.ht.Models.Images;
import oni.gouv.ht.Models.Institution;
import oni.gouv.ht.Models.Response;
import oni.gouv.ht.Repository.ImageRepository;
import oni.gouv.ht.Repository.InstitutionRepository;
import oni.gouv.ht.Repository.UserRepository;
import oni.gouv.ht.Utils.Constant;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InstitutionServiceImpl implements IInstitutionService {

    @Autowired
    InstitutionRepository institutionRepository;



    ModelMapper modelMapper;

    {
        modelMapper = new ModelMapper();
    }

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    UserRepository userRepository;


    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @Override
    public InstitutionBean CreateInstitution(InstitutionBean institutionBean, MultipartFile file) throws AlreadyExistdException, IOException {

        if(institutionBean==null || file==null){
            throw new AlreadyExistdException("Object null");        }

        if (institutionRepository.getInstitutionByName(institutionBean.getName()) != null) {
            throw new AlreadyExistdException(Constant.ORGANISATION_ALREADY_EXIST);
        }



        //save image institution teste if null
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

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username=null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        }

        institution.setCreateBy(userRepository.getUserByUsername(username).getId());
        Institution entityInstitution = institutionRepository.save(institution);

        InstitutionBean beanInstitution = modelMapper.map(entityInstitution, InstitutionBean.class);
        return beanInstitution;
    }

    @Override
    public List<InstitutionDto> getAllInsttitutionByCriteria() {
        Optional<List<InstitutionDto>> entity=institutionRepository.getAllInsttitutionByCriteria();
        if(!entity.isPresent()){
            return null;
        }
        return entity.get();
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
    public List<InstitutionBean> getAllInstitutions() {
        Optional<List<InstitutionDto>> entity=institutionRepository.getAllInstitutions();
        if(!entity.isPresent()){
            return null;
        }
        List<InstitutionBean> beanInstitution = modelMapper.map(entity.get(), ArrayList.class);
        return beanInstitution;
    }


}