package com.example.newswebsite.services;

import com.example.newswebsite.dao.DaoFactory;
import com.example.newswebsite.model.*;
import java.util.Collection;
import java.util.stream.Collectors;

public class NewsServiceImpl implements NewsService {

    DaoFactory daoFactory;

    public NewsServiceImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public News getNewsById(Integer newsId) {
        return daoFactory.getNewsDao().find(newsId);
    }

    @Override
    public Collection<News> getAllNews() {
        return daoFactory.getNewsDao().findAll();
    }

    @Override
    public Collection<News> getAllNews(NewsSortCriteria newsSortCriteria) {
        Collection<News> news = getAllNews();
        return sort(news, newsSortCriteria);
    }

    @Override
    public Collection<News> getNewsByCategory(Category category) {
        return daoFactory.getNewsDao().findByCategory(category);

    }

    public Category getCategoryByName(String categoryName) {
        for (Category category : daoFactory.getCategoryDao().getAllCategories()) {
            if (category.getCategoryName().equalsIgnoreCase(categoryName)) {
                return category;
            }
        }
        return null;
    }

    @Override
    public Collection<Category> getAllCategories() {
        return daoFactory.getCategoryDao().getAllCategories();
    }

    @Override
    public Collection<News> search(String keyWord, NewsSortCriteria newsSortCriteria) {
        Collection<News> news = search(keyWord);
        return sort(news, newsSortCriteria);
    }

    @Override
    public Collection<News> search(String keyWord) {
        if (keyWord == null || keyWord.equals(" ")) {
            return getAllNews();
        }
        return daoFactory.getNewsDao().searchByKeyword(keyWord);
    }

    private Collection<News> sort(Collection<News> news, NewsSortCriteria newsSortCriteria) {
        return news.stream()
                .sorted(NewsSorters.sorters.get(newsSortCriteria))
                .collect(Collectors.toList());
    }
    
    @Override
    public void addNews(News news) {
        daoFactory.getNewsDao().create(news, true);
    }
}
