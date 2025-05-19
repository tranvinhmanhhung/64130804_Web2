package hung.ntu64130804.quanlykhoahoconline.reposirory;

import hung.ntu64130804.quanlykhoahoconline.model.BorrowRecord;
import hung.ntu64130804.quanlykhoahoconline.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowRepository extends JpaRepository<BorrowRecord, Integer> {
    List<BorrowRecord> findByUser(User user);
}
