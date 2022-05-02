package oni.gouv.ht.Repository;


import dto.ApplicationDto;
import oni.gouv.ht.Models.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {


    @Query(value ="SELECT sum(amount) FROM request where app=:app ",nativeQuery = true)
    double getApplicationBynameAndRequestPrice(String app);


  /*  @Query(value ="select sum(amount) as price,app as name, institution as ins  from request group by app,institution",nativeQuery = true)
    Optional<List<AppDto>> getAllApplicationsByRequestPrice();*/




    @Query(value ="SELECT new dto.ApplicationDto(a.App,sum(a.amount),a.institution,count(a)) FROM Request a GROUP BY a.App, a.institution ")
    Optional<List<ApplicationDto>> getAllApplicationsByRequestPrice();

    @Query(value ="SELECT new dto.ApplicationDto('',sum(a.amount),a.institution,count(a)) FROM Request a GROUP BY a.institution ")
    Optional<List<ApplicationDto>> getAllInstByRequestPrice();


    @Query(value ="SELECT sum(amount) FROM request" ,nativeQuery = true)
     Double getAllRequestPrice();

    @Query(value ="SELECT new dto.ApplicationDto(a.App,sum(a.amount),a.institution,count(a)) FROM Request a  WHERE a.createDate BETWEEN  :debut AND :fin GROUP BY a.App, a.institution ")
    Optional<List<ApplicationDto>> getAllApplicationsByRequestPriceDate(LocalDateTime debut, LocalDateTime fin);

    @Query(value ="SELECT new dto.ApplicationDto('',sum(a.amount),a.institution,count(a)) FROM Request a WHERE a.createDate BETWEEN  :debut AND :fin GROUP BY a.institution ")
    Optional<List<ApplicationDto>> getAllInstByRequestPriceAndDate(LocalDateTime debut, LocalDateTime fin);


//    @Query(value ="SELECT new dto.ApplicationDto(a.) FROM Request a  WHERE a.name=:name ")
//    Optional<List<ApplicationDto>> getOneApplicationWithAllRequest(String name);


}
