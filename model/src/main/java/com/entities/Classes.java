package com.entities;


import javax.persistence.Entity;
import javax.persistence.Transient;

public class Classes {

    private Long id;
    private String time;
    private String aud;
    private String even;
    private Professors prof;
    private String day;
    private String disc;
    private StudGroup group;
    
    @Transient
    private String groupName;

    @Transient
    private String profName;

    public Classes() {
    }

    public String getProfName() {
        return profName;
    }

    public void setProfName(String profName) {
        this.profName = profName;
    }

    public StudGroup getGroup() {
        return group;
    }

    public void setGroup(StudGroup group) {
        this.group = group;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAud() {
        return aud;
    }

    public void setAud(String aud) {
        this.aud = aud;
    }

    public String getEven() {
        return even;
    }

    public void setEven(String even) {
        this.even = even;
    }

    public Professors getProf() {
        return prof;
    }

    public void setProf(Professors prof) {
        this.prof = prof;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }
}
