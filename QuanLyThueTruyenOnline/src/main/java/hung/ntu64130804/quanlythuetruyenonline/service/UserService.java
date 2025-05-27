package hung.ntu64130804.quanlythuetruyenonline.service;

import hung.ntu64130804.quanlythuetruyenonline.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(int id);
    Optional<User> findByName(String name);
    void save(User user);
    void deleteById(int id);
}
