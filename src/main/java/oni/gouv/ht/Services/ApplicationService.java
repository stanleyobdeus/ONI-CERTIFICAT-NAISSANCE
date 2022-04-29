package oni.gouv.ht.Services;


import dto.ApplicationDto;
import oni.gouv.ht.Bean.ApplicationBean;
import oni.gouv.ht.Exception.AlreadyExistdException;
import oni.gouv.ht.Exception.NotFoundException;
import oni.gouv.ht.Models.Application;
import oni.gouv.ht.Models.Institution;
import oni.gouv.ht.Repository.ApplicationRepository;
import oni.gouv.ht.Repository.InstitutionRepository;
import oni.gouv.ht.Repository.RequestRepository;
import oni.gouv.ht.Response.StatResponse;
import oni.gouv.ht.Utils.Constant;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ApplicationService implements IApplicationService {

    @Autowired
    InstitutionRepository institutionRepository;


    @Autowired
    RequestRepository requestRepository;

    @Autowired
    ApplicationRepository applicationRepository;

    ModelMapper modelMapper;

    {
        modelMapper = new ModelMapper();
    }

    @Override
    public Optional<Application> getAppByKey(String secretKey) {
        return applicationRepository.getAppBySecretKey(secretKey);
    }

    @Override
    public ApplicationBean createApplication(ApplicationBean applicationBean) throws AlreadyExistdException {

        if(applicationRepository.getAppByName(applicationBean.getName()).isPresent()){
            throw new AlreadyExistdException("Application Exist..!");
        }
       Institution  i = institutionRepository.getById(Long.parseLong(applicationBean.getId_institution()));
        if(i==null){
            return null;
        }
        Application application = new Application();
        application.setName(applicationBean.getName());
        application.setSecret_key(applicationBean.getId_institution() + "_" + genTokenForApplication(40));
        application.setPublic_key(genTokenForApplication(40));
        application.setCreate_date(LocalDateTime.now());
        application.setRequest_price(applicationBean.getRequest_price());
        application.setStrict((applicationBean.isStrict())? 1 : 0);
        application.setIns(i);
        Application entity= applicationRepository.save(application);
        ApplicationBean beanApplication = modelMapper.map(entity, ApplicationBean.class);
        return beanApplication;
    }

    @Override
    public ApplicationBean getAppByName(String name) throws NotFoundException {
        Optional<Application> entity = applicationRepository.getAppByName(name);
        if (entity.get() == null) {
            throw new NotFoundException(Constant.APPLICATION_NOT_FOUND);
        }
        ApplicationBean beanApplication = modelMapper.map(entity, ApplicationBean.class);
        return beanApplication;
    }

    @Override
    public Double getApplicationBynameAndRequestPrice(String name) throws NotFoundException {
        Optional<Application> entity = applicationRepository.getAppByName(name);
        if (entity.get() == null) {
            throw new NotFoundException(Constant.APPLICATION_NOT_FOUND);
        }
        return requestRepository.getApplicationBynameAndRequestPrice(name);
    }

    @Override
    public List<ApplicationDto> getAllApplicationsByRequestPrice() {
        Optional<List<ApplicationDto>> a = requestRepository.getAllApplicationsByRequestPrice();
        if (a.isPresent()) {
            return a.get();
        }
        return new ArrayList<ApplicationDto>();
    }

    @Override
    public List<ApplicationDto> getAllInstByRequestPrice() {
        Optional<List<ApplicationDto>> a = requestRepository.getAllInstByRequestPrice();
        if (a.isPresent()) {
            return a.get();
        }
        return new ArrayList<ApplicationDto>();
    }

    @Override
    public List<ApplicationDto> getAllApplicationsByRequestPriceDate(LocalDateTime debut, LocalDateTime fin) {
        if(debut==null || fin==null){
            return null;
        }

        Optional<List<ApplicationDto>> a = requestRepository.getAllApplicationsByRequestPriceDate(debut,fin);
        if (a.isPresent()) {
            return a.get();
        }
        return new ArrayList<ApplicationDto>();
    }

    @Override
    public List<ApplicationDto> getAllInstByRequestPriceAndDate(LocalDateTime debut, LocalDateTime fin) {
        if(debut==null || fin==null){
            return null;
        }
        Optional<List<ApplicationDto>> a = requestRepository.getAllInstByRequestPriceAndDate(debut,fin);
        if (a.isPresent()) {
            return a.get();
        }
        return new ArrayList<ApplicationDto>();
    }

    @Override
    public StatResponse getHomeStat() {
        StatResponse statResponse = new StatResponse();
        statResponse.setQtApp(applicationRepository.count());
        statResponse.setQtInst(institutionRepository.count());
        statResponse.setQtPrice(requestRepository.getAllRequestPrice());
        statResponse.setQtReq(requestRepository.count());
        return statResponse;
    }

    @Override
    public List<ApplicationDto> getAllAplications() {
        Optional<List<ApplicationDto>>entity=applicationRepository.getAllApplication();


        return entity.get();
    }


    public static String genTokenForApplication(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }
}