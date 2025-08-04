package com.tpopractice.myspringpractice.service;

import com.tpopractice.myspringpractice.repository.JpaUserRepository;
import com.tpopractice.myspringpractice.repository.UserRepository;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private EntityManager em;

    public SpringConfig(EntityManager em) { this.em = em; }

    @Bean
    public UserRepository userRepository() { return new JpaUserRepository(em); }
}
