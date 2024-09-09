package ageria.bookingManagement.repositories;

import ageria.bookingManagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

   List<User> findByFullNameStartingWith(String letterName);

    User findByUsername(String username);
    User findByEmail(String email);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

}
