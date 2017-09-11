package com.dao;

import com.entities.Professors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfDao extends JpaRepository<Professors, Long> {

    Professors findByName(String name);

    Professors findById(Long id);
}
