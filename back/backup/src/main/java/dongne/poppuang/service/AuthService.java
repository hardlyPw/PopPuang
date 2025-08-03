package dongne.poppuang.service;

import dongne.poppuang.dto.RegisterForm;
import dongne.poppuang.model.User;
import dongne.poppuang.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepo,
                       PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(RegisterForm form) {
        // 1) 이메일 중복 체크
        if (userRepo.existsByEmail(form.getEmail())) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }
        // 2) 비밀번호 일치 확인
        if (!form.getPassword().equals(form.getConfirmPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        // 3) 엔티티 생성
        User user = new User();
        user.setEmail(form.getEmail());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setDepartment(form.getDepartment());
        user.setRoles("ROLE_USER");
        user.setEnabled(true);
        // 4) 저장
        userRepo.save(user);
    }
}
