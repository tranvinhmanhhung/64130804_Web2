package hung.ntu64130804.quanlykhoahoconline.controller;

import hung.ntu64130804.quanlykhoahoconline.service.BookService;
import hung.ntu64130804.quanlykhoahoconline.service.BorrowService;
import hung.ntu64130804.quanlykhoahoconline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Homecontroller {
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BorrowService borrowService;

    @GetMapping({"/dashboard", "/", "/index"})
    public String dashboard(ModelMap model) {
        model.addAttribute("totalUsers", userService.findAll().size());
        model.addAttribute("totalBooks", bookService.findAll().size());
        model.addAttribute("totalBorrows", borrowService.findAll().size());
        return "views/DashBoard";
    }
}
