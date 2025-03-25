package edu.thomc.tonghopgk;

import model.StudentModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;


@Controller
public class Giuaki {
    private final List<StudentModel> students = new ArrayList<>();

    public Giuaki() {
        students.add(new StudentModel("64130053", "Nguyễn A", 7));
        students.add(new StudentModel("64130000", "Nguyễn B", 9.9));
        students.add(new StudentModel("64131234", "Đỗ C", 4.5));
        students.add(new StudentModel("64130343", "Lại D", 8.8));
    }

    @GetMapping("/")
    public String giuaKi(@RequestParam(name = "page", defaultValue = "home") String page, Model model) {
        model.addAttribute("page", page);

        if (page.equals("about")) {
            model.addAttribute("mssv", "64130053");
            model.addAttribute("hoVaTen", "Nguyễn Đức Anh");
            model.addAttribute("namSinh", "2003");
            model.addAttribute("gioiTinh", "Nam");
        } else if (page.equals("list")) {
            model.addAttribute("studentModelList", students);
        }
        return "FrontEndLayout";
    }

    @GetMapping("/add")
    public String showAddPage(Model model) {
        model.addAttribute("student", new StudentModel());
        return "FrontEndLayout";
    }

    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute StudentModel student) {
        students.add(student);
        return "redirect:/?page=list";
    }

}
