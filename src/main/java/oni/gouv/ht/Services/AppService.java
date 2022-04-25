package oni.gouv.ht.Services;


import dto.AppDto;
import oni.gouv.ht.Bean.ApplicationBean;
import oni.gouv.ht.Exception.NotFoundException;
import oni.gouv.ht.Models.Application;
import oni.gouv.ht.Models.Institution;
import oni.gouv.ht.Repository.AppRepository;
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
public class AppService implements IAppService {
    @Autowired
    AppRepository appDao;

    @Autowired
    InstitutionRepository institutionRepository;


    @Autowired
    RequestRepository requestRepository;

    ModelMapper modelMapper;

    {
        modelMapper = new ModelMapper();
    }

    @Override
    public Optional<Application> getAppByKey(String secretKey) {
        return appDao.getAppBySecretKey(secretKey);
    }

    @Override
    public Application createAppTest(Institution i) {
        long s = appDao.count();
        String c = "";
        if (s > 0) {
            c = "_" + s;
        }
        Application a = new Application("APP" + c, i.getId() + "_" + genTokenForApplication(40), genTokenForApplication(50));
        a.setIns(i);
        return appDao.save(a);
    }

    @Override
    public ApplicationBean getAppByName(String name) throws NotFoundException {
        Optional<Application> entity = appDao.getAppByName(name);
        if (entity.get() == null) {
            throw new NotFoundException(Constant.APPLICATION_NOT_FOUND);
        }
        ApplicationBean beanApplication = modelMapper.map(entity, ApplicationBean.class);
        return beanApplication;
    }

    @Override
    public Double getApplicationBynameAndRequestPrice(String name) throws NotFoundException {
        Optional<Application> entity = appDao.getAppByName(name);
        if (entity.get() == null) {
            throw new NotFoundException(Constant.APPLICATION_NOT_FOUND);
        }
        return requestRepository.getApplicationBynameAndRequestPrice(name);
    }

    @Override
    public List<AppDto> getAllApplicationsByRequestPrice() {
        Optional<List<AppDto>> a = requestRepository.getAllApplicationsByRequestPrice();
        if (a.isPresent()) {
            return a.get();
        }
        return new ArrayList<AppDto>();
    }

    @Override
    public List<AppDto> getAllInstByRequestPrice() {
        Optional<List<AppDto>> a = requestRepository.getAllInstByRequestPrice();
        if (a.isPresent()) {
            return a.get();
        }
        return new ArrayList<AppDto>();
    }

    @Override
    public List<AppDto> getAllApplicationsByRequestPriceDate(LocalDateTime debut, LocalDateTime fin) {
        if(debut==null || fin==null){
            return null;
        }

        Optional<List<AppDto>> a = requestRepository.getAllApplicationsByRequestPriceDate(debut,fin);
        if (a.isPresent()) {
            return a.get();
        }
        return new ArrayList<AppDto>();
    }

    @Override
    public List<AppDto> getAllInstByRequestPriceAndDate(LocalDateTime debut, LocalDateTime fin) {
        if(debut==null || fin==null){
            return null;
        }
        Optional<List<AppDto>> a = requestRepository.getAllInstByRequestPriceAndDate(debut,fin);
        if (a.isPresent()) {
            return a.get();
        }
        return new ArrayList<AppDto>();
    }

    @Override
    public StatResponse getHomeStat() {
        StatResponse statResponse = new StatResponse();
        statResponse.setQtApp(appDao.count());
        statResponse.setQtInst(institutionRepository.count());
        statResponse.setQtPrice(requestRepository.getAllRequestPrice());
        statResponse.setQtReq(requestRepository.count());
        return statResponse;
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