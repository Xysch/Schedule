package com.entities;


import java.util.Set;


public class StudGroup {

    private Long id;
    private String name;

    private Set<Students> stud;
    private Set<Classes> classes;

    public StudGroup() {
    }

    public Set<Classes> getClasses() {
        return classes;
    }

    public void setClasses(Set<Classes> classes) {
        this.classes = classes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Students> getStud() {
        return stud;
    }

    public void setStud(Set<Students> stud) {
        this.stud = stud;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
