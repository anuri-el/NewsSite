package com.example.newswebsite.dao.impl.inmemory;

import com.example.newswebsite.dao.CategoryDao;
import com.example.newswebsite.model.Category;
import java.util.Collection;

public class InMemoryCategoryDao extends InMemoryAbstractDao<Category> implements CategoryDao{
    
    InMemoryCategoryDao(InMemoryDatabase database){
        super(database.categories, Category::getCategoryId, Category::setCategoryId, database);
    }
    
    @Override
    public Collection<Category> getAllCategories(){
        return findAll();
    }
    
    @Override
    public void addCategory(Category category){
        create(category, true);
        
    }
    
    @Override
    public void deleteCategory(Category category){
        delete(category);
    }
    
}
