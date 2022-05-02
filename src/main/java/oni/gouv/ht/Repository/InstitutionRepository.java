package oni.gouv.ht.Repository;


import dto.InstitutionDto;
import oni.gouv.ht.Models.Application;
import oni.gouv.ht.Models.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
    @Query("SELECT o FROM Institution o WHERE o.name=:name")
    Institution getInstitutionByName(@Param("name") String name);

    @Query(value="SELECT new dto.InstitutionDto(a.name,a.id) from Institution a")
    Optional<List<InstitutionDto>> getAllInsttitutionByCriteria();


    @Query("SELECT new dto.InstitutionDto(institution) FROM Institution institution")
    Optional<List<InstitutionDto>> getAllInstitutions();

}
