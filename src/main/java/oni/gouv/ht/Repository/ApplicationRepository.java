package oni.gouv.ht.Repository;

import oni.gouv.ht.Models.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    @Query("SELECT a FROM Application  a WHERE a.secret_key=:sk")
    Optional<Application> getAppBySecretKey(String sk);

    @Query("SELECT a FROM Application  a WHERE a.name=:name")
    Optional<Application> getAppByName(String name);

    @Query("SELECT a FROM Application a")
    Optional<Application> getAllApplication();

}
