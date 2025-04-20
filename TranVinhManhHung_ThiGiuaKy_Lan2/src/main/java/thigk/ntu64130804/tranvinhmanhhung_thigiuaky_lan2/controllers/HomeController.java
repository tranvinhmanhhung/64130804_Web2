package thigk.ntu64130804.tranvinhmanhhung_thigiuaky_lan2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String dashBoard(ModelMap model) {
        model.addAttribute("mssv", "64130804");
        model.addAttribute("hoTen", "Trần Vĩnh Mạnh Hưng");
        model.addAttribute("namSinh","2004" );
        model.addAttribute("gioiTinh", "Nam");
        return "Dashboard";
    }
}
