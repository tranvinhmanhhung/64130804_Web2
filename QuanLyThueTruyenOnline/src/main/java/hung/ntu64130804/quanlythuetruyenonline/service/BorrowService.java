package hung.ntu64130804.quanlythuetruyenonline.service;

import hung.ntu64130804.quanlythuetruyenonline.model.Borrow;
import hung.ntu64130804.quanlythuetruyenonline.model.User;

import java.util.List;
import java.util.Optional;

public interface BorrowService {
    List<Borrow> findAll();
    List<Borrow> findByUser(User user);
    Optional<Borrow> findById(int id);
    void save(Borrow borrow);
    void deleteById(int id);
}
