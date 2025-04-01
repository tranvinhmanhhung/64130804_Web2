package thigk.ntu64130804.tranvinhmanhhung_cvsinhvien;

import model.Student;
import model.Topic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic(1, "AI Research", "Research on Artificial Intelligence", 101, "Research"),
            new Topic(2, "Web Development", "Building modern web applications", 102, "Development"),
            new Topic(3, "Cyber Security", "Exploring security vulnerabilities", 103, "Security")
    ));

    private List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1, "Nguyen Van A", 1),
            new Student(2, "Tran Thi B", 1),
            new Student(3, "Le Van C", 2)
    ));

    @GetMapping("/")
    public String home() {
        return "homePage";
    }

    @GetMapping("/topics")
    public String getTopics(Model model) {
        model.addAttribute("topics", topics);
        model.addAttribute("content", "topics");
        return "homePage";
    }

    @GetMapping("/students")
    public String getStudents(Model model) {
        model.addAttribute("students", students);
        model.addAttribute("content", "students");
        return "homePage";
    }
}
