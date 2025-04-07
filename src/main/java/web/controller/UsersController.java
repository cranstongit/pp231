package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping //browser address
    public String printUsers(ModelMap model) {
            model.addAttribute("getUsers", userService.findAll()); //attribute in the index.html
        return "/index"; //spring will be looking for an index.html file
    }

    @GetMapping("/newuser")
    public String createUser(ModelMap model) {
        model.addAttribute("newUser", new User());
        return "/new";
    }

    @PostMapping("/newuser")
    public String newUser(@ModelAttribute("newUser") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/deleteuser")
    public String deleteUser(ModelMap model) {
        return "/delete";
    }

    @PostMapping("/deleteuser")
    public String removeUser(@RequestParam("id") long id) {
        userService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edituser")
    public String chageUser(ModelMap model) {
        model.addAttribute("updateUser", new User());
        return "/edit";
    }

    @PostMapping("/edituser")
    public String updateUser(@ModelAttribute("updateUser") long id, User user) {
        userService.update(id, user);
        return "redirect:/";
    }

}
