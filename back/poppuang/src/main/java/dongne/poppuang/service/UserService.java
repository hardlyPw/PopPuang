package dongne.poppuang.service;
import dongne.poppuang.domain.EnumMajors;
import dongne.poppuang.domain.Major;
import dongne.poppuang.domain.RegisterDto;
import dongne.poppuang.domain.User;
import dongne.poppuang.repository.MajorRepository;
import dongne.poppuang.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final MajorRepository majorRepository;
    public UserService(UserRepository userRepository, MajorRepository majorRepository) {
        this.userRepository = userRepository;
        this.majorRepository = majorRepository;
    }

    private final Map<String,String> users = new ConcurrentHashMap<>();
    
    @Transactional
    public User createUser(RegisterDto registerDto) {
        String uid = registerDto.getUsername();
        // 아이디 중복 확인 필요

        EnumMajors enum_major = EnumMajors.valueOf(registerDto.getDepartment());
        Optional<Major> major = majorRepository.findById((long) (enum_major.ordinal() + 1));
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

    // 이 메서드 추가
    @Transactional
    public Long incrementClicks(String uid) {
        User user = userRepository.findByUid(uid)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + uid));
        return user.clickIncrement(); // JPA가 트랜잭션 끝날 때 자동 저장
    }

    public boolean authenticate(String username, String password) {
        return userRepository.findPwByUid(username) // userRepository.findByUid.get().getPw()로 비번 찾기 가능 -지성
                .map(storedPw -> storedPw.equals(password)) // 비번 비교
                .orElse(false); // uid 없으면 false
    }

    public String getMajor(String username) {
        return userRepository.findByUid(username).get().getMajor().getName();
    }

    // 테스트/디버깅용: 전체 사용자 보기 (운영금지)
    public Map<String,String> getAllUsers() {
        return users;
    }
}
