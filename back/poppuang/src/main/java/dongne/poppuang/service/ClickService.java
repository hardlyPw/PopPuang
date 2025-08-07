package dongne.poppuang.service;

import dongne.poppuang.domain.EnumMajors;
import dongne.poppuang.repository.MajorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static dongne.poppuang.domain.EnumMajors.*;

@Service
public class ClickService {
    MajorRepository majorRepository;

    public ClickService(MajorRepository majorRepository) { this.majorRepository = majorRepository; }

    @Transactional
    public Long addClick(String major_name) {
        EnumMajors enumMajor = EnumMajors.valueOf(major_name);
        return majorRepository.addClick((long) enumMajor.ordinal());
    }

}

