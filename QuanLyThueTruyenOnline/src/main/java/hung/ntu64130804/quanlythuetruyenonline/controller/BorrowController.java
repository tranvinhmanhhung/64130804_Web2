package hung.ntu64130804.quanlythuetruyenonline.controller;


import hung.ntu64130804.quanlythuetruyenonline.model.Borrow;
import hung.ntu64130804.quanlythuetruyenonline.model.User;
import hung.ntu64130804.quanlythuetruyenonline.service.BorrowService;
import hung.ntu64130804.quanlythuetruyenonline.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String getAllBorrows(ModelMap model) {
        List<Borrow> borrowList = borrowService.findAll();
        model.addAttribute("borrowList", borrowList);
        return "views/BorrowListAdmin";
    }

    @GetMapping("/my")
    public String getMyBorrows(HttpSession session, ModelMap model) {
        User currentUser = (User) session.getAttribute("loggedInUser");
        if (currentUser == null) {
            return "redirect:/login";
        }

        List<Borrow> borrows = borrowService.findByUser(currentUser);
        model.addAttribute("borrowList", borrows);
        return "views/borrow/BorrowListUser";
    }
}
