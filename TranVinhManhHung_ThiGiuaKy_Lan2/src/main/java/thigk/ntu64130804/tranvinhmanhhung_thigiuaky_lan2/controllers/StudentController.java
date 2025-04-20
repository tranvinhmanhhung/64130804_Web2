package thigk.ntu64130804.tranvinhmanhhung_thigiuaky_lan2.controllers;

import thigk.ntu64130804.tranvinhmanhhung_thigiuaky_lan2.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    private final List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student("SV001", "Nguyen Van A", "G001"));
        students.add(new Student("SV002", "Tran Thi B", "G002"));
        students.add(new Student("SV003", "Le Van C", "G001"));
        students.add(new Student("SV004", "Pham Thi D", "G003"));
        students.add(new Student("SV005", "Hoang Van E", "G002"));
    }

    @GetMapping("/student/all")
    public String getAllStudents(ModelMap model) {
        model.addAttribute("studentList", students);
        return "view/StudentList";
    }

    @GetMapping("/student/new")
    public String getNewStudent(ModelMap model) {
        model.addAttribute("student", new Student());
        return "view/StudentNew";
    }

    @PostMapping("/student/new")
    public String postNewStudent(@ModelAttribute Student student) {
        students.add(student);
        return "redirect:/student/all";
    }

    @GetMapping("/student/view/{id}")
    public String getStudentById(@PathVariable String id, ModelMap model) {
        Student student = students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
        model.addAttribute("studentView", student);
        return "view/StudentView";
    }

    @GetMapping("/student/edit/{id}")
    public String getEditStudent(@PathVariable String id, ModelMap model) {
        Student student = students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
        model.addAttribute("studentEdit", student);
        return "view/StudentEdit";
    }

    @PostMapping("/student/edit/{id}")
    public String postEditStudent(@PathVariable String id, @ModelAttribute Student student) {
        Student existingStudent = students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (existingStudent != null) {
            existingStudent.setName(student.getName());
            existingStudent.setGroupId(student.getGroupId());
        }
        return "redirect:/student/all";
    }

    @GetMapping("/student/delete/{id}")
    public String getDeleteStudent(@PathVariable String id) {
        students.removeIf(s -> s.getId().equals(id));
        return "redirect:/student/all";
    }
}