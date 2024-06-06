package com.example.newswebsite.dao.impl.inmemory;

import com.example.newswebsite.dao.*;


public class InMemoryDaoFactory implements DaoFactory {
    InMemoryDatabase database;
    
    CategoryDao categoryDao;
    
    NewsDao newsDao;
    
    UserDao userDao;

    public InMemoryDaoFactory(InMemoryDatabase database) {
        this.database = database;
        categoryDao = new InMemoryCategoryDao(database);
        newsDao = new InMemoryNewsDao(database);
        userDao = new InMemoryUserDao(database);
    }
    
    @Override 
    public CategoryDao getCategoryDao(){
        return categoryDao;
    }
    
    @Override 
    public NewsDao getNewsDao(){
        return newsDao;
    }
    
    @Override 
    public UserDao getUserDao(){
        return userDao;
    }
}
