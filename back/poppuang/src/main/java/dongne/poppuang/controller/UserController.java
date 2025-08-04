package com.tpopractice.myspringpractice.controller;

import com.tpopractice.myspringpractice.domain.RegisterDto;
import com.tpopractice.myspringpractice.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    UserService userService;
    public UserController(UserService userService) { this.userService = userService; }

    @PostMapping("/register-submit")
    public String registerSubmit(@ModelAttribute RegisterDto registerDto) {
        userService.createUser(registerDto);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute RegisterDto registerDto) {
        return "redirect:/";
    }

}
