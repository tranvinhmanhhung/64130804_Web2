package hung.ntu64130804.demojba.controllers;

import hung.ntu64130804.demojba.models.Student;
import hung.ntu64130804.demojba.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public String getAllStudents(ModelMap model) {
        List<Student> students = studentService.getAllStudent();
        model.addAttribute("students", students);
        return "students";
    }
}
