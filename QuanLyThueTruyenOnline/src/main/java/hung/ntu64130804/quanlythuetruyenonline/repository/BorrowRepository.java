package hung.ntu64130804.quanlythuetruyenonline.repository;


import hung.ntu64130804.quanlythuetruyenonline.model.Borrow;
import hung.ntu64130804.quanlythuetruyenonline.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowRepository extends JpaRepository<Borrow, Integer> {
    List<Borrow> findByUser(User user);
}
