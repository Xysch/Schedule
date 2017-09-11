package com.services;

import com.entities.StudGroup;

import java.util.List;

public interface StudGroupService {

    void save(StudGroup group);

    StudGroup findGroupByName(String name);

    List<StudGroup> findAll();

    StudGroup findById(Long id);

    void deleteByName(String name);
}
