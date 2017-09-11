package com.dao;

import com.entities.Classes;
import com.entities.StudGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassesDao extends JpaRepository<Classes, Long>{

    List<Classes> findAll();

    List<Classes> findByGroup(StudGroup group);

    List<Classes> findByDay(String day);

    Classes findById(Long id);

    void deleteById(Long id);

    List<Classes> findByGroupAndDay(StudGroup group, String day);


    List<Classes> findByGroupAndDayAndTime(StudGroup group, String day, String time);

    List<Classes> findByDayAndTimeAndAud(String day, String time, String aud);

}
