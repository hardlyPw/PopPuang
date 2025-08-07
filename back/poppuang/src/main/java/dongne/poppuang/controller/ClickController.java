package dongne.poppuang.controller;

import dongne.poppuang.domain.User;
import dongne.poppuang.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ClickController {

    private final UserService userService;

    public ClickController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/click")
    @ResponseBody
    public void handleClick() {
        Long testUserId = 1L;  // 테스트용 유저 ID
        userService.incrementClicks(testUserId);
    }
}