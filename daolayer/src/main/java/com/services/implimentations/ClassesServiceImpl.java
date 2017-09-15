package com.services.implimentations;

import com.dao.ClassesDao;
import com.dao.ProfDao;
import com.dao.StudGroupDao;
import com.entities.Classes;
import com.entities.StudGroup;
import com.services.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesDao classesDao;

    @Autowired
    private ProfDao profDao;

    @Autowired
    private StudGroupDao groupDao;

    public void save(Classes classes){
        classes.setGroup(groupDao.findByName(classes.getGroupName()));
        classes.setProf(profDao.findByName(classes.getProfName()));
        classesDao.save(classes);
    }

    public List<Classes> findByGroup(StudGroup group){
        return classesDao.findByGroup(group);
    }

    public List<Classes> findByDay(String day){
        return classesDao.findByDay(day);
    }

    @Transactional
    public Classes findById(Long id){
        return classesDao.findById(id);
    }

    @Transactional
    public void deleteById(Long id){
        classesDao.deleteById(id);
    }

    public void save(List<Classes> classes){
        classesDao.save(classes);
    }

    public List<Classes> findByGroupAndDay(StudGroup group, String day){
        return classesDao.findByGroupAndDay(group, day);
    }


    public List<Classes> findByGroupAndDayAndTime(StudGroup group, String day, String time){
        return classesDao.findByGroupAndDayAndTime(group, day, time);
    }

    public List<Classes> findByDayAndTimeAndAud(String day, String time, String aud){
        return classesDao.findByDayAndTimeAndAud(day, time, aud);
    }

}
