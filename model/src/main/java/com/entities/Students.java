package com.entities;



import java.beans.Transient;
import java.util.HashSet;
import java.util.Set;

public class Students {

    private Long id;
    private String username;
    private String password;
    private String fName;
    private String lName;
    private Long phone;
    private String mail;
    private StudGroup group;


    private Set<UserRole> userRole = new HashSet<UserRole>(10);

    private String confirmPassword;
    private String groupName;

    public Students() {
    }

    @Transient
    public String getGroupName() {
        return groupName;
    }

    @Transient
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Transient
    public String getConfirmPassword() {
        return confirmPassword;
    }

    @Transient
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }


    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public StudGroup getGroup() {
        return group;
    }

    public void setGroup(StudGroup group) {
        this.group = group;
    }

    public Set<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }
}
