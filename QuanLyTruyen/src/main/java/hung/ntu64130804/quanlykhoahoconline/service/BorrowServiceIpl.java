package hung.ntu64130804.quanlykhoahoconline.service;

import hung.ntu64130804.quanlykhoahoconline.model.BorrowRecord;
import hung.ntu64130804.quanlykhoahoconline.model.User;
import hung.ntu64130804.quanlykhoahoconline.reposirory.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowServiceIpl implements BorrowService {
    @Autowired
    private BorrowRepository borrowRepository;

    @Override
    public List<BorrowRecord> findAll() {
        return borrowRepository.findAll();
    }

    @Override
    public List<BorrowRecord> findByUser(User user) {
        return borrowRepository.findByUser(user);
    }

    @Override
    public Optional<BorrowRecord> findById(int id) {
        return borrowRepository.findById(id);
    }

    @Override
    public void save(BorrowRecord borrow) {
        borrowRepository.save(borrow);
    }

    @Override
    public void deleteById(int id) {
        borrowRepository.deleteById(id);
    }
}
