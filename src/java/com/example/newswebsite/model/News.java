package com.example.newswebsite.model;

import java.time.LocalDateTime;

public class News {

    private Integer newsId;
    private String title;
    private String content;
    private Category category;
    private LocalDateTime publishedDate;

    public News(Integer newsId, String title, String content, Category category) {
        this(newsId, title, content, category, LocalDateTime.now());
    }

    public News(Integer newsId, String title, String content, Category category, LocalDateTime publishedDate) {
        this.newsId = newsId;
        this.title = title;
        this.content = content;
        this.category = category;
        this.publishedDate = publishedDate;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Category getCategory() {
        return category;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

}
