package com.dao;

import com.entities.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<Students, Long> {
    Students findByUsername(String username);
}
