package com.example.newswebsite.dao.impl.inmemory;

import com.example.newswebsite.dao.NewsDao;
import com.example.newswebsite.model.Category;
import com.example.newswebsite.model.News;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InMemoryNewsDao extends InMemoryAbstractDao<News> implements NewsDao {

    InMemoryNewsDao(InMemoryDatabase database){
        super(database.news, News::getNewsId, News::setNewsId, database);
    }
    
    @Override
    public Collection<News> findByCategory(Category category) {
        return database.news.values().stream()
                .filter(news -> news.getCategory().equals(category))
                .collect(Collectors.toList());

    }

    @Override
    public Collection<News> searchByKeyword(String keyword) {
        String[] words = keyword.toLowerCase().split(" ");
        return database.news.values().stream()
                .filter(news ->containKeyWords(news,words))
                .collect(Collectors.toList());
    }

    private static boolean containKeyWords(News news, String[] words) {
        String string = news.getTitle() + " " + news.getContent();
        string = string.toLowerCase();
        return Stream.of(words).allMatch(string::contains);

    }

}
