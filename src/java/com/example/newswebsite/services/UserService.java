package com.example.newswebsite.services;

import com.example.newswebsite.model.User;

public interface UserService {
    
    User getByLogin(String login);
    
    boolean checkPassword(User user, String password);
    
}
