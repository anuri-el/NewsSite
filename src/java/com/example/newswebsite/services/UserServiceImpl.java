package com.example.newswebsite.services;

import com.example.newswebsite.dao.DaoFactory;
import com.example.newswebsite.model.User;
import java.util.function.UnaryOperator;

public class UserServiceImpl implements UserService {

    DaoFactory daoFactory;
    UnaryOperator<String> passwordHasher;

    public UserServiceImpl(DaoFactory daoFactory, UnaryOperator<String> passwordHasher) {
        this.daoFactory = daoFactory;
        this.passwordHasher = passwordHasher;
    }

    @Override
    public User getByLogin(String login) {
        return daoFactory.getUserDao().getByLogin(login);

    }

    @Override
    public boolean checkPassword(User user, String password) {
        return user.getPasswordHash().equals(passwordHasher.apply(password));
    }
}
