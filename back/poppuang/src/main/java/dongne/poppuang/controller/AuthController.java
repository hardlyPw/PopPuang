package dongne.poppuang.controller;

import dongne.poppuang.domain.LoginDto;
import dongne.poppuang.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

import java.util.Arrays;

@Controller
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/login")
    public String loginSubmit(LoginDto loginDto,
                              HttpSession session,
                              Model model) {
        if (userService.authenticate(loginDto.getUsername(), loginDto.getPassword())) {
            session.setAttribute("username", loginDto.getUsername());
            // 테스트용 비번 저장은 나중에 지우는 게 안전
            System.out.println("성공");
            return "redirect:/";
        }
        //실패시
        return "login";
    }
    
    public String loginSubmit(String username, String password,
                              HttpSession session, HttpServletResponse response, Model model) {
        if (userService.authenticate(username, password)) {
            session.setAttribute("username", username);

            Cookie major_cookie = new Cookie("major", userService.getMajor(username));
            major_cookie.setDomain("localhost");
            major_cookie.setPath("/");
            major_cookie.setMaxAge(60*30);
            major_cookie.setSecure(true);
            response.addCookie(major_cookie);

            model.addAttribute("isLoggedIn", true);

            return "home";

        } else {
            model.addAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.");
            System.out.println("실패");
            return "login";
        }
    }

    // 로그아웃 예시
    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletResponse response, Model model) {
        session.invalidate();
        Cookie major_cookie = new Cookie("major", null);
        major_cookie.setMaxAge(0);
        response.addCookie(major_cookie);
        model.addAttribute("isLoggedIn", false);
        return "login";
    }
}
