package com.tpopractice.myspringpractice.controller;

import com.tpopractice.myspringpractice.service.ClickService;
import com.tpopractice.myspringpractice.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    private TestService testService;
    public TestController(TestService testService) { this.testService = testService; }

    @GetMapping("/test")
    public String test() {
        testService.addMajor();
        return "redirect:/";
    }
}
