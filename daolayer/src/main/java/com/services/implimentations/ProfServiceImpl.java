package com.services.implimentations;

import com.dao.ProfDao;
import com.entities.Professors;
import com.services.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfServiceImpl implements ProfService {

    @Autowired
    private ProfDao profDao;

    public Professors findByName(String name){
        return profDao.findByName(name);
    }

    public Professors findById(Long id){
        return profDao.findById(id);
    }

    public void save(Professors prof){
        profDao.save(prof);
    }

}
