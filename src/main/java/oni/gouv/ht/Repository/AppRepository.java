package oni.gouv.ht.Repository;

import dto.AppDto;
import oni.gouv.ht.Models.Application;
import oni.gouv.ht.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppRepository extends JpaRepository<Application, Long> {
    @Query("SELECT a FROM Application  a WHERE a.secret_key=:sk")
    Optional<Application> getAppBySecretKey(String sk);




    @Query("SELECT a FROM Application  a WHERE a.name=:name")
    Optional<Application> getAppByName(String name);





    /*@Query(value ="SELECT a FROM Application a where a.create_date=:create_date ")
    Optional<Application> getAppByDate(LocalDateTime create_date);*/


  /*  @Query(value ="SELECT a FROM Application a where a.create_date=:create_date and a.name=:name")
    Optional<Application> getApplicationByNameAndDate(LocalDateTime create_date,String name);*/




}
