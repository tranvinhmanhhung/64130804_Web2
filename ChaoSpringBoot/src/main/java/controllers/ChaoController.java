package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ChaoController {
    @GetMapping("/chao")
    public String chao(ModelMap model) {
        model.addAttribute("tb", "chao");
        return "chao";
    }


}
