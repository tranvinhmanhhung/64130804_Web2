package hung.ntu64130804.quanlykhoahoconline.service;

import hung.ntu64130804.quanlykhoahoconline.model.User;
import hung.ntu64130804.quanlykhoahoconline.reposirory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AuthServiceIpl implements AuthService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> login(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user.getPassword().equals(password)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean register(User user) {
        if(userRepository.findByName(user.getName().trim()).isPresent() ||
                userRepository.findByEmail(user.getEmail().trim()).isPresent()){
            return false;
        }
        userRepository.save(user);
        return true;
    }
}
