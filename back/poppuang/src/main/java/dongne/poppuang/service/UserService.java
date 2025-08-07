package dongne.poppuang.service;

import dongne.poppuang.domain.EnumMajors;
import dongne.poppuang.domain.Major;
import dongne.poppuang.domain.RegisterDto;
import dongne.poppuang.domain.User;
import dongne.poppuang.repository.MajorRepository;
import dongne.poppuang.repository.UserRepository;
import static dongne.poppuang.domain.EnumMajors.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final MajorRepository majorRepository;
    public UserService(UserRepository userRepository, MajorRepository majorRepository) {
        this.userRepository = userRepository;
        this.majorRepository = majorRepository;
    }

    @Transactional
    public User createUser(RegisterDto registerDto) {
        String uid = registerDto.getUsername();
        // 아이디 중복 확인 필요

        EnumMajors enum_major = EnumMajors.valueOf(registerDto.getDepartment());
        Optional<Major> major = majorRepository.findById(Long.valueOf(enum_major.ordinal()));
        // 학과명이 없을 때 로직 필요 (major == null 일 때)

        String pw = registerDto.getPassword();
        // 비번 검증?

        User user = new User();
        user.setUid(uid);
        user.setMajor(major.get());
        user.setPw(pw); // 해시 아직 안함
        user.setClicks(0L);
        user.setCreated_at(new Timestamp(System.currentTimeMillis()));

        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    // 이 메서드 추가
    @Transactional
    public void incrementClicks(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + userId));
        user.setClicks(user.getClicks() + 1);
        userRepository.save(user);  // JPA 영속성 컨텍스트가 관리 중이면 save() 없이도 flush 시 반영됩니다.
    }

    public Optional<User> findByUid(String uid) {
        return userRepository.findByUid(uid);
    }
}
