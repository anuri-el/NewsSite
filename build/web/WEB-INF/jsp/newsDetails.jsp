<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${news.title}</title>
        <link rel="stylesheet" type="text/css" href="../css/style.css">
    </head>
    <body>
        <%@include file="header.jspf" %>
        
        <section>
            <div class="news-details">
                <h1>${news.title}</h1>
                <p>Category: ${news.category.categoryName}</p>
                <p>Published: ${news.publishedDate.dayOfMonth}.${news.publishedDate.monthValue}.${news.publishedDate.year} ${news.publishedDate.hour}:${news.publishedDate.minute}</p>
                <p>${news.content}</p>
                
            </div>
            
        </section>
        <%@include file="footer.jspf" %>
    </body>
</html>
