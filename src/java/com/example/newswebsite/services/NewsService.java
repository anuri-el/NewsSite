package com.example.newswebsite.services;

import com.example.newswebsite.model.*;
import java.util.Collection;

public interface NewsService {
    Collection<News> getAllNews();
    
    Collection<News> getAllNews(NewsSortCriteria newsSortCriteria);
    
    Collection<News> getNewsByCategory(Category category);
    
    Category getCategoryByName(String categoryName);
    
    Collection<Category> getAllCategories();

    Collection<News> search(String keyWord);
    
    Collection<News> search(String keyWord, NewsSortCriteria newsSortCriteria);

    News getNewsById(Integer newsId);
    
    void addNews(News news);
}
