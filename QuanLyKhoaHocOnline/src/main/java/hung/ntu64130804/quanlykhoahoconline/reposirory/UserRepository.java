package hung.ntu64130804.quanlykhoahoconline.reposirory;

import hung.ntu64130804.quanlykhoahoconline.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByName(String name);
}
