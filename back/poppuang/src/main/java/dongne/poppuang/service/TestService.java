package com.tpopractice.myspringpractice.service;

import com.tpopractice.myspringpractice.domain.Major;
import com.tpopractice.myspringpractice.repository.TestRepository;
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
