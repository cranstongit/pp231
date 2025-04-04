package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user-list") //browser address
    public String printCars(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
            model.addAttribute("getUsers", userService.listUsers()); //attribute in the users.html
        return "/users"; //spring will be looking for a users.html file
    }
}
