package dongne.poppuang.controller;

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
    public String home(Model model) {
        model.addAttribute("time", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
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
