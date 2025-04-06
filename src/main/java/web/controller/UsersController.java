package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping //browser address
    public String printUsers(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
            model.addAttribute("getUsers", userService.findAll()); //attribute in the users.html
        return "/users"; //spring will be looking for a users.html file
    }
}
