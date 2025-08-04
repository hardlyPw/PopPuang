package com.tpopractice.myspringpractice.controller;

import com.tpopractice.myspringpractice.domain.LeaderboardEntry;
import com.tpopractice.myspringpractice.service.LeaderboardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("time", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return "home";
    }

    @GetMapping("/register")
    public String signup() {
        return "signUp";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
