package dongne.poppuang.controller;

import dongne.poppuang.domain.LoginDto;
import dongne.poppuang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

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
        } else {
            model.addAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.");
            System.out.println("실패");
            return "login";
        }
    }

    // 로그아웃 예시
    @GetMapping("/logout")
    public String logout(HttpSession session, Model model) {
        session.invalidate();
        model.addAttribute("isLoggedIn", false);
        return "redirect:/login";
    }
}
