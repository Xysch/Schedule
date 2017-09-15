package com.dao;

import com.entities.StudGroup;
import com.entities.Students;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface UserDao extends JpaRepository<Students, Long> {
    Students findByUsername(String username);

    void deleteByUsername(String username);

    List<Students> findAll();

    List<Students> findAllByGroup(StudGroup group);


}

