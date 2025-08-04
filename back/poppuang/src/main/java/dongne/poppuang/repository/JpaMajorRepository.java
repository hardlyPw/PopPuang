package com.tpopractice.myspringpractice.repository;

import com.tpopractice.myspringpractice.domain.Major;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class JpaMajorRepository implements MajorRepository {
    private final EntityManager em;
    public JpaMajorRepository(EntityManager em) { this.em = em; }

    @Override
    public Long addClick(String name) {
        Major target = findByName(name);

        target.setClicks(target.getClicks() + 1);

        return target.getClicks();
    }

    @Override
    public Major findByName(String name) {
        List<Major> result = em.createQuery("SELECT m FROM Major m WHERE m.name = :name", Major.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny().get();
    }

    @Override
    public List<Major> findAll() {
        return List.of();
    }
}
