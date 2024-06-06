<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>News Site</title>
        <link rel="stylesheet" type="text/css" href="../css/style.css">
    </head>
    <body class="body-news">
        <%@include file="header.jspf" %>

        <section class="section-news">
            <h1 class="heading-news">Latest News</h1>
            <hr class="hr-news">

            <form action="newsByCategory" method="get" class="form-filter-news">
                <label for="category" class="label-news">Select Category:</label>
                <select id="category" name="categoryName" class="select-category">
                    <option value="">All</option>
                    <c:forEach var="category" items="${categories}">
                        <option value="${category.categoryName}">${category.categoryName}</option>
                    </c:forEach>
                </select>
                <button type="submit" class="btn-filter-news">Filter</button>
            </form>
            
            <form action="../secret/addNews" method="post" class="form-add-news">
                <button type="submit" class="btn-add-news">Add news</button>
            </form>
            
            <table class="table-news">
                <thead>
                    <tr>
                        <th>
                            <a href="search?sort=BY_DATE_NEW_FIRST&text=${param.text}" class="sort-news">Latest</a>,
                            <a href="search?sort=BY_DATE_OLD_FIRST&text=${param.text}" class="sort-news">Oldest</a>,
                            <a href="search?sort=BY_TITLE&text=${param.text}" class="sort-news">By Title</a>
                        </th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="newsItem" items="${news}">

                        <tr class="news-item">
                            <td>
                                <a href="newsDetails?newsId=${newsItem.newsId}" class="link-news">${newsItem.title}</a>
                                <p class="category-news">${newsItem.category.categoryName}</p>
                                <p class="content-news">${newsItem.content}</p>
                                <p class="published-news">Published: ${newsItem.publishedDate.dayOfMonth}.${newsItem.publishedDate.monthValue}.${newsItem.publishedDate.year} ${newsItem.publishedDate.hour}:${newsItem.publishedDate.minute}</p>

                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>
        <%@include file="footer.jspf" %>
    </body>
</html>