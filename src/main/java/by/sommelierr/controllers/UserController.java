package by.sommelierr.controllers;

import by.sommelierr.models.User;
import by.sommelierr.repository.UserRepository;
import by.sommelierr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public String users(Model model){
        if(userService.isNotExecutable()) return "redirect:/login";
        userService.setLoginDate();
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

    @GetMapping("/error")
    public String error(){
        if(userService.isNotExecutable()) return "redirect:/login";
        return "/error";
    }

    @PostMapping("/users")
    public String users(@RequestParam List<Long> checkId, @RequestParam String action){
        if(userService.isNotExecutable()) return "redirect:/login";
        userService.doAction(action,checkId);
        if(userService.isNotExecutable()) return "redirect:/login";
        return "redirect:/users";
    }
}
