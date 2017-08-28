package com.services;

import com.entities.Students;

public interface UserService{

    Students findByUsername(String username);

    void save(Students user);
}
