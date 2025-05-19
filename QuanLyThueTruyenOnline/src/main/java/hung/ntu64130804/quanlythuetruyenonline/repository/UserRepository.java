package hung.ntu64130804.quanlythuetruyenonline.repository;

import hung.ntu64130804.quanlythuetruyenonline.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByName(String name);
}
