package hung.ntu64130804.quanlythuetruyenonline.service;

import hung.ntu64130804.quanlythuetruyenonline.model.User;

import java.util.Optional;

public interface AuthService {
    Optional<User> login(String email, String password);
    boolean register(User user);
}
