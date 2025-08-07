package dongne.poppuang.controller;

import dongne.poppuang.service.ClickService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClickController {
    private ClickService clickService;
    public ClickController(ClickService clickService) { this.clickService = clickService; }

    // 푸앙이 클릭하면 쿠키의 major에 해당하는 값을 넣어줌, 지금은 TestController에서 임의로 설정함
    @PostMapping("/click")
    public void click(@CookieValue(name="id") String id) {
        clickService.addClick(id);
    }
}
