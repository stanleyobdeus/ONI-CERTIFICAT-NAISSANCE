package oni.gouv.ht.Repository;

import oni.gouv.ht.Models.Application;
import oni.gouv.ht.Models.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
    @Query("SELECT o FROM Institution o WHERE o.name=:name")
    Institution getInstitutionByName(@Param("name") String name);
}
