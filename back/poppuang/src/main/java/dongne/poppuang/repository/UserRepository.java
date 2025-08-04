package com.tpopractice.myspringpractice.repository;

import com.tpopractice.myspringpractice.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByUid(String uid);
    List<User> findAll();
}
