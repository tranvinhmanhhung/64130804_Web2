package thigk.ntu64130804.tranvinhmanhhung_cvsinhvien;

import model.Student;
import model.Topic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String home(Model model) {
        model.addAttribute("Ten", "Trần Vĩnh Mạnh Hưng");
        model.addAttribute("Tuoi", "21");
        model.addAttribute("GioiTinh", "Nam");
        model.addAttribute("DiaChi", "Vĩnh Thọ, Nha Trang");
        return "homePage";
    }



    @GetMapping("/topics")
    public String getTopics(Model model) {
        model.addAttribute("topics", topics);
        model.addAttribute("content", "topics");
        return "homePage";
    }

    @GetMapping("/topic/view/{id}")
    public String viewTopic(@PathVariable("id") int id, Model model) {
        Topic topic = topics.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
        model.addAttribute("topic", topic);
        return "topicView";
    }

    @GetMapping("/topic/new")
    public String addTopicForm(Model model) {
        model.addAttribute("topic", new Topic(0, "", "", 0, ""));
        return "topicForm";
    }

    @PostMapping("/topic/save")
    public String saveTopic(@ModelAttribute Topic topic) {
        if (topic.getId() == 0) {
            topic.setId(topics.size() + 1);
            topics.add(topic);
        } else {
            for (int i = 0; i < topics.size(); i++) {
                if (topics.get(i).getId() == topic.getId()) {
                    topics.set(i, topic);
                    break;
                }
            }
        }
        return "redirect:/topics";
    }

    @GetMapping("/topic/delete/{id}")
    public String deleteTopic(@PathVariable("id") int id) {
        topics.removeIf(t -> t.getId() == id);
        return "redirect:/topics";
    }



    @GetMapping("/students")
    public String getStudents(Model model) {
        model.addAttribute("students", students);
        model.addAttribute("content", "students");
        return "homePage";
    }

    @GetMapping("/student/view/{id}")
    public String viewStudent(@PathVariable("id") int id, Model model) {
        Student student = students.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
        model.addAttribute("student", student);
        return "studentView";
    }

    @GetMapping("/student/new")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student(0, "", 0));
        return "studentForm";
    }

    @PostMapping("/student/save")
    public String saveStudent(@ModelAttribute Student student) {
        if (student.getId() == 0) {
            student.setId(students.size() + 1);
            students.add(student);
        } else {
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getId() == student.getId()) {
                    students.set(i, student);
                    break;
                }
            }
        }
        return "redirect:/students";
    }

    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        students.removeIf(s -> s.getId() == id);
        return "redirect:/students";
    }
}
