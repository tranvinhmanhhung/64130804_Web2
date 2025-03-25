package edu.thomc.tonghopgk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Giuaki {
    @GetMapping("/")
    public String giuaki() {
        return "FrontEndLayout";
    }

    @GetMapping("/about")
    public String about() {
        return "layout/about";
    }

    @GetMapping("/list")
    public String List() {
        return "header";
    }

    @RequestMapping("/addnew")
    public String Addrow() {
        return "body";
    }

}
