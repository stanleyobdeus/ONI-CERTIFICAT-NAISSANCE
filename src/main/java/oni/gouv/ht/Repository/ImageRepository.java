package oni.gouv.ht.Repository;

import oni.gouv.ht.Models.Images;
import oni.gouv.ht.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Images, Long> {
}
