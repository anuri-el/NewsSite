package com.example.newswebsite.dao;

import com.example.newswebsite.model.Category;
import java.util.Collection;

public interface CategoryDao extends AbstractDao<Category> {
    Collection<Category> getAllCategories();
      
    void addCategory(Category category);
     
    void deleteCategory(Category category);
    
}
