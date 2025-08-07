package dongne.poppuang.service;

import dongne.poppuang.repository.MajorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClickService {
    MajorRepository majorRepository;

    public ClickService(MajorRepository majorRepository) { this.majorRepository = majorRepository; }

    @Transactional
    public void addClick() {
        long clicks = majorRepository.addClick("간호학과");
        System.out.println();
        System.out.println(clicks);
        System.out.println();
    }
}
