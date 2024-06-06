package com.example.newswebsite.web;

import com.example.newswebsite.dao.DaoFactory;
import com.example.newswebsite.dao.impl.inmemory.*;
import com.example.newswebsite.services.*;
import jakarta.servlet.*;
import java.util.function.UnaryOperator;

public class ApplicationContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        InMemoryDatabase database = new InMemoryDatabase();
        InMemoryTestData.generateTo(database);

        DaoFactory daoFactory = database.getDaoFactory();
        NewsService newsService = new NewsServiceImpl(daoFactory);
        UserService userService = new UserServiceImpl(daoFactory, UnaryOperator.identity());

        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("newsService", newsService);
        servletContext.setAttribute("userService", userService);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}