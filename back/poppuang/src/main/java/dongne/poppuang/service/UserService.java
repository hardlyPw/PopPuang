package dongne.poppuang.service;

import dongne.poppuang.domain.RegisterDto;
import dongne.poppuang.domain.User;
import dongne.poppuang.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) { this.userRepository = userRepository; }

    @Transactional
    public User createUser(RegisterDto registerDto) {
        User user = new User();
        user.setUid(registerDto.getUsername());
        user.setMajor(registerDto.getDepartment());
        user.setPw(registerDto.getPassword()); // 해시 아직 안함
        user.setCreated_at(new Timestamp(System.currentTimeMillis()));

        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findByUid(String uid) {
        return userRepository.findByUid(uid);
    }
}
