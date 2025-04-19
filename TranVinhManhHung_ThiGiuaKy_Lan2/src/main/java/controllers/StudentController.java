package controllers;

import models.Student;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private final List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student("1", "Nguyen Van A", "Excellent student in Java programming", "1"));
        students.add(new Student("2", "Tran Thi B", "Good performance in Spring Boot", "2"));
        students.add(new Student("3", "Le Van C", "Skilled in Hibernate ORM", "2"));
        students.add(new Student("4", "Pham Thi D", "Beginner but enthusiastic learner", "3"));
        students.add(new Student("5", "Hoang Van E", "Outstanding web development project", "3"));
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
    public String postEditStudent(@PathVariable String id, @ModelAttribute Student updatedStudent) {
        Student student = students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (student != null) {
            student.setTitle(updatedStudent.getTitle());
            student.setContent(updatedStudent.getContent());
            student.setCategoryId(updatedStudent.getCategoryId());
        }
        return "redirect:/student/all";
    }

    @GetMapping("/student/delete/{id}")
    public String getDeleteStudent(@PathVariable String id) {
        students.removeIf(s -> s.getId().equals(id));
        return "redirect:/student/all";
    }
}
