package com.example.newswebsite.services;

import com.example.newswebsite.model.News;
import java.util.Comparator;
import static java.util.Comparator.*;
import java.util.HashMap;
import java.util.Map;

public class NewsSorters {
    
    public static final Map<NewsSortCriteria, Comparator<News>> sorters;
    
    static{
        sorters = new HashMap<>();
        sorters.put(NewsSortCriteria.OLD_FIRST, comparing(News::getNewsId));
        sorters.put(NewsSortCriteria.NEW_FIRST, comparing(News::getNewsId,reverseOrder()));
        sorters.put(NewsSortCriteria.BY_TITLE, comparing(News::getTitle));
        sorters.put(NewsSortCriteria.BY_DATE_OLD_FIRST, comparing(News::getPublishedDate));
        sorters.put(NewsSortCriteria.BY_DATE_NEW_FIRST, comparing(News::getPublishedDate,reverseOrder()));
    }
    
}
