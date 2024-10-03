package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")  
public class User {

    @Id
    @Column(name = "user")  
    private String user;

    @Column(name = "pass")
    private String pass;

    @Column(name = "role")
    private String role;


    // Getters Setters
    public User() {}

        public User(String user, String pass, String role) {
        this.user = user;
        this.pass = pass;
        this.role = role;
    } 

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
