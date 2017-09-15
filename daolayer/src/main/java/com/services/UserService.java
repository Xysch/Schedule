package com.services;

import com.entities.Classes;
import com.entities.StudGroup;
import com.entities.Students;

import java.util.List;

public interface UserService{

    Students findByUsername(String username);

    void save(Students user);

    void updateUser(Students user);

    List<Students> findAll();

    void deleteByUsername(String username);

    StudGroup getGroupById(Long id);

    StudGroup findGroupByStudent(Students user);

    List<Students> findAllByGroup(StudGroup group);

    void save(List<Students> students);


}
