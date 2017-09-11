package com.services;

import com.entities.Professors;

public interface ProfService {

    void save(Professors prof);

    Professors findByName(String name);

    Professors findById(Long id);
}
