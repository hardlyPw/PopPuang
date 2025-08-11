package dongne.poppuang.controller;

import dongne.poppuang.domain.RegisterDto;
import dongne.poppuang.service.UserService;
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

}
