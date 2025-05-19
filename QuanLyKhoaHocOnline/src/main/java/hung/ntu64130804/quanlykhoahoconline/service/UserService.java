package hung.ntu64130804.quanlykhoahoconline.service;

import hung.ntu64130804.quanlykhoahoconline.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService{
    List<User> findAll();
    Optional<User> findById(int id);
    void save(User user);
    void deleteById(int id);
}
