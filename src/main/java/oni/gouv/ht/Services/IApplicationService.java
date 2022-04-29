package oni.gouv.ht.Services;



import dto.ApplicationDto;
import oni.gouv.ht.Bean.ApplicationBean;
import oni.gouv.ht.Exception.AlreadyExistdException;
import oni.gouv.ht.Exception.NotFoundException;
import oni.gouv.ht.Models.Application;
import oni.gouv.ht.Response.StatResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IApplicationService {

    Optional<Application> getAppByKey(String secretKey);

    ApplicationBean createApplication(ApplicationBean applicationBean) throws AlreadyExistdException;


    ApplicationBean getAppByName(String name) throws NotFoundException;

    Double getApplicationBynameAndRequestPrice(String name) throws NotFoundException;

    List<ApplicationDto> getAllApplicationsByRequestPrice();

    List<ApplicationDto> getAllInstByRequestPrice();


    List<ApplicationDto> getAllApplicationsByRequestPriceDate(LocalDateTime debut, LocalDateTime fin);
    List<ApplicationDto> getAllInstByRequestPriceAndDate(LocalDateTime debut, LocalDateTime fin);

    StatResponse getHomeStat();

    List<ApplicationDto>  getAllAplications();


}