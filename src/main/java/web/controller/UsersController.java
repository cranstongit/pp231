package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String newUser(ModelMap model) {
        model.addAttribute("newUser", new User());
        return "/new";
    }

    @PostMapping
    public String newUser(@ModelAttribute("newUser") User user) {
        userService.save(user);
        return "redirect:/";
    }

//    @PostMapping()
//    public String create(@ModelAttribute("person") @Valid Person person,
//                         BindingResult bindingResult) {
//        if (bindingResult.hasErrors())
//            return "people/new";
//
//        peopleService.save(person);
//        return "redirect:/people";
//    }
//
//    @GetMapping
//    public String edit(Model model, @PathVariable("id") int id) {
//        model.addAttribute("editUser", userService.findOne(id));
//        return "/users";
//    }
//
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult,
//                         @PathVariable("id") int id) {
//        if (bindingResult.hasErrors())
//            return "people/edit";
//
//        peopleService.update(id, person);
//        return "redirect:/people";
//    }
//
//    @DeleteMapping
//    public String delete(@PathVariable("id") int id) {
//        peopleService.delete(id);
//        return "/users";
//    }

//    @GetMapping
//    public String method(@RequestParam(value = "id", required = false) Long id, @RequestParam(value = "name", required = false, Model model) String name) {
//        model.addAtribute("") //кладем пару ключ значение в атрибут
//        return "/uses";
//    }

}
