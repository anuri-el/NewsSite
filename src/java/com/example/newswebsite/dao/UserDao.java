package com.example.newswebsite.dao;

import com.example.newswebsite.model.User;

public interface UserDao extends AbstractDao<User>{
    
    User getByLogin(String login);
}