package com.services.implimentations;

import com.dao.StudGroupDao;
import com.entities.StudGroup;
import com.services.StudGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudGroupServiceImpl implements StudGroupService {

    @Autowired
    private StudGroupDao groupDao;

    @Override
    public void save(StudGroup group){
        groupDao.save(group);
    }

    @Transactional
    public StudGroup findGroupByName(String name){
        return groupDao.findByName(name);
    }

    public List<StudGroup> findAll(){
        return  groupDao.findAll();
    }

    public StudGroup findById(Long id){
        return groupDao.findById(id);
    }

    @Transactional
    public void deleteByName(String name){
        groupDao.deleteByName(name);
    }
}
