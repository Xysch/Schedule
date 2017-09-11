package com.services;

import com.entities.Classes;
import com.entities.StudGroup;

import java.util.List;

public interface ClassesService {

    void save(Classes classes);

    List<Classes> findByGroup(StudGroup group);

    List<Classes> findByDay(String day);

    Classes findById(Long id);

    void deleteById(Long id);

    void save(List<Classes> classes);

    List<Classes> findByGroupAndDay(StudGroup group, String day);

    List<Classes> findByGroupAndDayAndTime(StudGroup group, String day, String time);

    List<Classes> findByDayAndTimeAndAud(String day, String time, String aud);

}
