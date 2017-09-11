package com.dao;

import com.entities.StudGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudGroupDao extends JpaRepository<StudGroup, Long>{

    StudGroup findByName(String name);

    List<StudGroup> findAll();

    StudGroup findById(Long id);

    void deleteByName(String name);

}
