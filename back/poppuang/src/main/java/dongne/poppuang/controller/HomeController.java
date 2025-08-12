package dongne.poppuang.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import dongne.poppuang.domain.Major;
import dongne.poppuang.repository.JpaMajorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class HomeController {

    private final JpaMajorRepository jpaMajorRepository;

    public HomeController(JpaMajorRepository jpaMajorRepository) {
        this.jpaMajorRepository = jpaMajorRepository;
    }

    @GetMapping("/")
    public String home(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false); // 기존 세션 가져오기, 없으면 null 반환
        if (session != null && !session.isNew()) {
            // 세션이 존재하고 새로 생성된 세션이 아닌 경우 (로그인 상태)
            String username = (String) session.getAttribute("username");
            if (username != null) {
                // 사용자 ID가 저장되어 있는 경우 (로그인 상태)
                model.addAttribute("isLoggedIn", true);
            }
        } else {
            // 세션이 없거나 새로 생성된 세션인 경우 (로그아웃 상태)
            model.addAttribute("isLoggedIn", false);
        }
        return "home";
    }

    @GetMapping("/register")
    public String signup(Model model) {
        List<Major> majors = jpaMajorRepository.findAll();
        model.addAttribute("majors", majors); // major객체 자체를 뷰로 넘겨줌. 뷰에서도 major.name이런식으로 활용가능. Major객체 리스트 majors를 넘김
        return "signUp";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
