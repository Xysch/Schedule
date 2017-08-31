package com.dao;

import com.entities.Students;
import com.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface UserDao extends JpaRepository<Students, Long> {
    Students findByUsername(String username);

    void deleteByUsername(String username);

    List<Students> findAll();

    void deleteById(Long id);

    Students findById(Long id);



}

