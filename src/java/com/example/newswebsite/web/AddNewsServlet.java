package com.example.newswebsite.web;

import com.example.newswebsite.model.Category;
import com.example.newswebsite.model.News;
import com.example.newswebsite.services.NewsService;
import jakarta.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "AddNewsServlet", urlPatterns = {"/secret/addNews"})
public class AddNewsServlet extends HttpServlet {

    NewsService newsService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
        newsService = (NewsService) config.getServletContext().getAttribute("newsService");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String categoryName = request.getParameter("categoryName");

        if (title == null || content == null || categoryName == null
                || title.isEmpty() || content.isEmpty() || categoryName.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/secret/addNews.jsp?error=1");
            return;
        }

        Category category = newsService.getCategoryByName(categoryName);
        if (category == null) {
            response.sendRedirect(request.getContextPath() + "/secret/addNews.jsp?error=2");
            return;
        }

        News news = new News(null, title, content, category);

        newsService.addNews(news);

        response.sendRedirect(request.getContextPath() + "/do/news");
    }

}
