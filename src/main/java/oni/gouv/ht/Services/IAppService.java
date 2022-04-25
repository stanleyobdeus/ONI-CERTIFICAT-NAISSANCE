package oni.gouv.ht.Services;



import dto.AppDto;
import oni.gouv.ht.Bean.ApplicationBean;
import oni.gouv.ht.Exception.NotFoundException;
import oni.gouv.ht.Models.Application;
import oni.gouv.ht.Models.Institution;
import oni.gouv.ht.Models.Response;
import oni.gouv.ht.Response.StatResponse;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IAppService {

    Optional<Application> getAppByKey(String secretKey);

    Application createAppTest(Institution i);


    ApplicationBean getAppByName(String name) throws NotFoundException;

    Double getApplicationBynameAndRequestPrice(String name) throws NotFoundException;

    List<AppDto> getAllApplicationsByRequestPrice();

    List<AppDto> getAllInstByRequestPrice();


    List<AppDto> getAllApplicationsByRequestPriceDate(LocalDateTime debut, LocalDateTime fin);
    List<AppDto> getAllInstByRequestPriceAndDate(LocalDateTime debut, LocalDateTime fin);

    StatResponse getHomeStat();
}