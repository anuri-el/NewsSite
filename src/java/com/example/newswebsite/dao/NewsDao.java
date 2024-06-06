package com.example.newswebsite.dao;

import com.example.newswebsite.model.Category;
import com.example.newswebsite.model.News;
import java.util.Collection;

public interface NewsDao extends AbstractDao<News> {
      
    Collection<News> findByCategory(Category category);
    
    Collection<News> searchByKeyword(String keyword);
    
}
