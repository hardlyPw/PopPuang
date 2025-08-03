package dongne.poppuang.controller;

import dongne.poppuang.dto.RegisterForm;
import dongne.poppuang.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // 회원가입 폼
    @GetMapping("/signUp")
    public String showSignUpForm(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "signUp";  // templates/signUp.html
    }

    // 회원가입 처리
    @PostMapping("/signUp")
    public String register(
            @Valid @ModelAttribute("registerForm") RegisterForm form,
            BindingResult bindingResult,
            Model model
    ) {
        // 1) 폼 검증 실패
        if (bindingResult.hasErrors()) {
            return "signUp";
        }
        try {
            // 2) 회원가입 로직
            authService.register(form);
        } catch (IllegalArgumentException e) {
            // 3) 비즈니스 예외 처리
            model.addAttribute("registrationError", e.getMessage());
            return "signUp";
        }
        // 4) 성공 시 로그인 페이지로 리다이렉트
        return "redirect:/login?registered";
    }
}
