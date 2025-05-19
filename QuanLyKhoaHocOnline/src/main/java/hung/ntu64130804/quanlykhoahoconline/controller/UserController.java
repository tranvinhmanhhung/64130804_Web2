package hung.ntu64130804.quanlykhoahoconline.controller;

import hung.ntu64130804.quanlykhoahoconline.model.User;
import hung.ntu64130804.quanlykhoahoconline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public String getAllUsers(ModelMap model) {
        List<User> users = userService.findAll();
        model.addAttribute("userList", users);
        return "views/UserList";
    }

    @GetMapping("/new")
    public String getNewUserForm(ModelMap model) {
        model.addAttribute("user", new User());
        return "views/UserCreate";
    }

    @PostMapping("/new")
    public String postNewUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/users/all";
    }

    @GetMapping("/view/{id}")
    public String viewUser(@PathVariable("id") int id, ModelMap model) {
        Optional<User> userOpt = userService.findById(id);
        if (userOpt.isPresent()) {
            model.addAttribute("userDetail", userOpt.get());
            return "views/UserView";
        } else {
            return "redirect:/users/all";
        }
    }

    @GetMapping("/edit/{id}")
    public String getEditUserForm(@PathVariable("id") int id, ModelMap model) {
        Optional<User> userOpt = userService.findById(id);
        if (userOpt.isPresent()) {
            model.addAttribute("userEdit", userOpt.get());
            return "views/UserEdit";
        } else {
            return "redirect:/users/all";
        }
    }

    @PostMapping("/edit/{id}")
    public String postEditUser(@PathVariable("id") int id, @ModelAttribute User user) {
        Optional<User> existingUserOpt = userService.findById(id);
        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setRole(user.getRole());
            userService.save(existingUser);
        }
        return "redirect:/users/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/users/all";
    }
}
