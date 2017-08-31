package com.entities;


import java.util.HashSet;
import java.util.Set;


public class Classes {

    private int id;
    private String time;
    private String aud;
    private String even;
    private Professors prof;
    private String day;
    private String disc;
    private Set<StudGroup> groups = new HashSet<StudGroup>();

    public Classes() {
    }

    public Set<StudGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<StudGroup> groups) {
        this.groups = groups;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
