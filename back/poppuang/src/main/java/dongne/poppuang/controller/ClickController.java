package dongne.poppuang.controller;

import dongne.poppuang.service.ClickService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClickController {
    private ClickService clickService;
    public ClickController(ClickService clickService) { this.clickService = clickService; }

    @PostMapping("/click")
    public void click(HttpServletRequest request) {
        // 세션 검사
        HttpSession session = request.getSession(false); // 기존 세션 가져오기, 없으면 null 반환
        if (session != null && !session.isNew()) {
            // 세션이 존재하고 새로 생성된 세션이 아닌 경우 (로그인 상태)
            String username = (String) session.getAttribute("username");
            if (username != null) {
                // 사용자 ID가 저장되어 있는 경우 (로그인 상태)
                clickService.addClick(username);
            }
        } else {
            // 세션이 없거나 새로 생성된 세션인 경우 (로그아웃 상태)
            // 필요시 로직 추가
        }
    }
}
