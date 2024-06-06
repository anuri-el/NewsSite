package com.example.newswebsite.dao;

import java.util.Collection;

public interface AbstractDao<T> {
    
    T find(Integer id);
    
    Collection<T> findAll();
    
    void create(T entity, boolean generatedId);
                        
    void update(T entity);
            
    void delete(T entity);
    
}
