package com.example.newswebsite.model;

import java.util.Objects;

public class User {
    
    private Integer userId;
    private String name;
    private String login;
    private String passwordHash;

    public User(Integer userId, String name, String login, String password) {
        this.userId = userId;
        this.name = name;
        this.login = login;
        this.passwordHash = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.userId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.userId, other.userId)){
            return false;
        }
        return true;
    }
}
