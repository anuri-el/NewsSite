package com.example.newswebsite.web;

import com.example.newswebsite.model.*;
import com.example.newswebsite.services.*;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.Collection;

@WebServlet(name = "FrontControllerServlet", urlPatterns = {"/do/*"})
public class FrontControllerServlet extends HttpServlet {

    NewsService newsService;
    UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
        newsService = (NewsService) config.getServletContext().getAttribute("newsService");
        userService = (UserService) config.getServletContext().getAttribute("userService");

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            pathInfo = "/";
        }
        try {
            switch (pathInfo) {
                case "/login":
                    login(request, response);
                    break;
                case "/logout":
                    logout(request, response);
                    break;
                case "/newsDetails":
                    newsDetails(request, response);
                    break;
                case "/newsByCategory":
                    newsByCategory(request, response);
                    break;
                case "/addNews":
                    addNews(request, response);
                    break;
                case "/":
                case "/search":
                case "/news":
                default:
                    news(request, response);
                    break;
            }
        } catch (RuntimeException ex) {
            error(request, response, "Error: " + ex.getMessage());
        }
    }

    protected void news(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchText = request.getParameter("text");
        String sort = request.getParameter("sort");
        NewsSortCriteria sortCriteria;
        if (sort == null || sort.equals("")) {
            sortCriteria = NewsSortCriteria.BY_DATE_NEW_FIRST;
        } else {
            sortCriteria = NewsSortCriteria.valueOf(sort);
        }

        Collection<News> news = newsService.search(searchText, sortCriteria);
        Collection<Category> categories = newsService.getAllCategories();
        request.setAttribute("news", news);
        request.setAttribute("text", searchText);
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/WEB-INF/jsp/news.jsp").forward(request, response);
    }

    protected void newsByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryName = request.getParameter("categoryName");
        if (categoryName == null || categoryName.isEmpty()) {
            error(request, response, "Category name is required");
            return;
        }

        Category category = newsService.getCategoryByName(categoryName);
        if (category == null) {
            error(request, response, "Category not found: " + categoryName);
            return;
        }

        Collection<News> news = newsService.getNewsByCategory(category);
        request.setAttribute("news", news);
        request.setAttribute("categoryName", categoryName);
        request.getRequestDispatcher("/WEB-INF/jsp/news.jsp").forward(request, response);
    }

    protected void addNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getMethod().equalsIgnoreCase("POST")) {
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            String categoryName = request.getParameter("categoryName");

            if (title == null || content == null || categoryName == null
                    || title.isEmpty() || content.isEmpty() || categoryName.isEmpty()) {
                error(request, response, "Title, content, and category name are required");
                return;
            }

            Category category = newsService.getCategoryByName(categoryName);
            if (category == null) {
                error(request, response, "Category not found: " + categoryName);
                return;
            }

            News news = new News(null, title, content, category);
            newsService.addNews(news);
            response.sendRedirect("news");
        } else {
            request.getRequestDispatcher("/WEB-INF/jsp/addNews.jsp").forward(request, response);
        }
    }

    protected void newsDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int newsId = Integer.parseInt(request.getParameter("newsId"));
        News news = newsService.getNewsById(newsId);
        request.setAttribute("news", news);
        request.getRequestDispatcher("/WEB-INF/jsp/newsDetails.jsp").forward(request, response);
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        String login = request.getParameter("login");
        User user = userService.getByLogin(login);
        if (user == null) {
            error(request, response, login + " does not exist");
            return;
        }
        String password = request.getParameter("password");
        if (!userService.checkPassword(user, password)) {
            error(request, response, "Wrong password");
            return;
        }
        request.getSession().setAttribute("user", user);
        response.sendRedirect(".");
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("news", newsService.getAllNews());
        request.getSession().invalidate();
        response.sendRedirect(".");
    }

    protected void error(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        request.setAttribute("message", message);
        request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
