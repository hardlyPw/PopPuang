package com.tpopractice.myspringpractice.repository;

import com.tpopractice.myspringpractice.domain.Major;

import java.util.List;
import java.util.Optional;

public interface MajorRepository {
    Long addClick(String name);
    Major findByName(String name);
    List<Major> findAll();
}
