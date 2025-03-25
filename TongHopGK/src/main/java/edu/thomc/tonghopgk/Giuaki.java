package edu.thomc.tonghopgk;

import model.StudentModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;


@Controller
public class Giuaki {
    @GetMapping("/")
    public String giuaKi(@RequestParam(name = "page", defaultValue = "home") String page, ModelMap model) {
        model.addAttribute("page", page);

        if (page.equals("about")) {
            model.addAttribute("mssv", "64130804");
            model.addAttribute("hoVaTen", "Trần Vĩnh Mạnh Hưng");
            model.addAttribute("namSinh", "2004");
            model.addAttribute("gioiTinh", "Nam");
        } else if (page.equals("list")) {
            List<StudentModel> students = List.of(
                    new StudentModel("64130000", "Nguyễn A", 7),
                    new StudentModel("64130000", "Nguyễn B", 9.9),
                    new StudentModel("64131888", "Đỗ C", 4.5),
                    new StudentModel("64130666", "Lại D", 8.8)
            );
            model.addAttribute("studentModelList", students);
        }  else if (page.equals("addNew")) {



        }
        return "FrontEndLayout";
    }

}
