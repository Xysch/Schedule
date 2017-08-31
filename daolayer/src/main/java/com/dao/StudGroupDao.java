package com.dao;

import com.entities.StudGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudGroupDao extends JpaRepository<StudGroup, Long>{

    StudGroup findByName(String name);

    List<StudGroup> findAll();

    StudGroup findById(Long id);


}
