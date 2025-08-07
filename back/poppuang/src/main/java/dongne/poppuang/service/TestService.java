package dongne.poppuang.service;

import dongne.poppuang.domain.Major;
import dongne.poppuang.repository.TestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {
    TestRepository testRepository;
    public TestService(TestRepository testRepository) { this.testRepository = testRepository; }

    @Transactional
    public void addMajor() {
        Major major = new Major();
        major.setName("간호학과");
        major.setClicks(0L);
        testRepository.addMajor(major);
    }

}
