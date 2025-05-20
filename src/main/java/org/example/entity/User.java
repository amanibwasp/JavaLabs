package org.example.entity;

public class User {
    public String username;
    public String password;
    public Boolean isAdmin;

    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }
}