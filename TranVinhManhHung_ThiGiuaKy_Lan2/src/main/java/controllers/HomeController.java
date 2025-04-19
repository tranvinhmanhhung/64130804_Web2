package controllers;

import models.Topic;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {
    @RequestMapping("/")
    public String dashBoard(Model model) {
        model.addAttribute("mssv", "64130804");
        model.addAttribute("hoten", "Trần Vĩnh Mạnh Hưng");
        model.addAttribute("namsinh","2004" );
        model.addAttribute("gioitinh", "Nam");
        return "Dashboard";
    }
}
