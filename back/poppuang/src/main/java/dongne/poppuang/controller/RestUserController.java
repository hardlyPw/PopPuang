package com.tpopractice.myspringpractice.controller;

import com.tpopractice.myspringpractice.domain.User;
import com.tpopractice.myspringpractice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestUserController {
    UserService userService;
    public RestUserController(UserService userService) { this.userService = userService; }

    @GetMapping("/userlist")
    public List<User> userlist() {
        return userService.findAll();
    }
}
