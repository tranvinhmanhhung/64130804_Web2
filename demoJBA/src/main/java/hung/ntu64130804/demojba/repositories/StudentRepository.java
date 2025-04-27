package hung.ntu64130804.demojba.repositories;

import hung.ntu64130804.demojba.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
