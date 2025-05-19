package hung.ntu64130804.quanlythuetruyenonline.service;

import hung.ntu64130804.quanlythuetruyenonline.model.Borrow;
import hung.ntu64130804.quanlythuetruyenonline.model.User;
import hung.ntu64130804.quanlythuetruyenonline.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowServiceIpl implements BorrowService {
    @Autowired
    private BorrowRepository borrowRepository;

    @Override
    public List<Borrow> findAll() {
        return borrowRepository.findAll();
    }

    @Override
    public List<Borrow> findByUser(User user) {
        return borrowRepository.findByUser(user);
    }

    @Override
    public Optional<Borrow> findById(int id) {
        return borrowRepository.findById(id);
    }

    @Override
    public void save(Borrow borrow) {
        borrowRepository.save(borrow);
    }

    @Override
    public void deleteById(int id) {
        borrowRepository.deleteById(id);
    }
}
