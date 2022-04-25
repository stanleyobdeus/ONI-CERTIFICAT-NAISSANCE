package oni.gouv.ht.Repository;

import oni.gouv.ht.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRequestRepository extends JpaRepository<User, Long> {
}
