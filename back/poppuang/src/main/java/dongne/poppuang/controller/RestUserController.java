package dongne.poppuang.controller;

import dongne.poppuang.domain.User;
import dongne.poppuang.service.UserService;
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
