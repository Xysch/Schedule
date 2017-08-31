package com.entities;


import java.util.Set;


public class Professors {

    private int id;
    private String name;

    private Set<Classes> cls;

    public Professors() {
    }

    public Set<Classes> getCls() {
        return cls;
    }

    public void setCls(Set<Classes> cls) {
        this.cls = cls;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
