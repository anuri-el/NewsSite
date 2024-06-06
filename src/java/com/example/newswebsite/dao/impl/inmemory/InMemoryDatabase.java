package com.example.newswebsite.dao.impl.inmemory;

import com.example.newswebsite.dao.DaoFactory;
import com.example.newswebsite.model.*;
import java.util.Map;
import java.util.TreeMap;

public class InMemoryDatabase {
    
    Map<Integer, News> news;
    Map<Integer, Category> categories;
    Map<Integer, User> users;
    
    public InMemoryDatabase(){
        news = new TreeMap<>();
        categories = new TreeMap<>();
        users = new TreeMap<>();
    }

    public DaoFactory getDaoFactory(){
        return new InMemoryDaoFactory(this);
    }
    
}
