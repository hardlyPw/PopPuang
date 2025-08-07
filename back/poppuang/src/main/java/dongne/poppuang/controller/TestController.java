package dongne.poppuang.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    // "localhost:8080/test"로 들어가면 "major - 간호학과"인 쿠키 생성, 인터넷에서 대충 찾아서 쓴거라 정확한지는 모름
    // 쿠키 확인은 f12 - elements console ... 옆에 더보기 - Application - Storage 탭에 Cookies
    @GetMapping("/test")
    public String createCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("major", "간호학과");
        cookie.setDomain("localhost");
        cookie.setPath("/");
        cookie.setMaxAge(60);
        cookie.setSecure(true);
        response.addCookie(cookie);

        return "redirect:/";
    }
}
