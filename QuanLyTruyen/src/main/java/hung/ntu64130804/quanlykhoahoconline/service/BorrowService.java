package hung.ntu64130804.quanlykhoahoconline.service;

import hung.ntu64130804.quanlykhoahoconline.model.BorrowRecord;
import hung.ntu64130804.quanlykhoahoconline.model.User;

import java.util.List;
import java.util.Optional;

public interface BorrowService {
    List<BorrowRecord> findAll();
    List<BorrowRecord> findByUser(User user);
    Optional<BorrowRecord> findById(int id);
    void save(BorrowRecord borrow);
    void deleteById(int id);
}
