package hung.ntu64130804.demojba.services;

import hung.ntu64130804.demojba.models.Student;
import hung.ntu64130804.demojba.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
}
