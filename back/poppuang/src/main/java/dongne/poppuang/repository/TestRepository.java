package com.tpopractice.myspringpractice.repository;

import com.tpopractice.myspringpractice.domain.Major;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TestRepository {
    private final EntityManager em;
    public TestRepository(EntityManager em) { this.em = em; }

    public void addMajor(Major major) {
        em.persist(major);
    }

}
