package dongne.poppuang.controller;

import dongne.poppuang.service.ClickService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClickController {
    private ClickService clickService;
    public ClickController(ClickService clickService) { this.clickService = clickService; }

    @PostMapping("/click")
    public void click() {
        clickService.addClick();
    }
}
