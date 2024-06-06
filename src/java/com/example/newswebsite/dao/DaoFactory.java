package com.example.newswebsite.dao;

public interface DaoFactory {

    CategoryDao getCategoryDao();
    
    NewsDao getNewsDao();
    
    UserDao getUserDao();

}
