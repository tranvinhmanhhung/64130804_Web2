package hung.ntu64130804.quanlythuetruyenonline.controller;

import hung.ntu64130804.quanlythuetruyenonline.service.BookService;
import hung.ntu64130804.quanlythuetruyenonline.service.BorrowService;
import hung.ntu64130804.quanlythuetruyenonline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
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
