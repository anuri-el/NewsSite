<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add News</title>
        <link rel="stylesheet" type="text/css" href="../css/style.css">
    </head>
    <body>
        
        
    <h1>Add news</h1>
    <form action="addNews" method="post">
        <label for="title">Title:</label><br>
        <input type="text" id="title" name="title"><br>
        <label for="content">Content:</label><br>
        <textarea id="content" name="content"></textarea><br>
        <label for="category">Category:</label><br>
        <select id="category" name="categoryName">
            <option value="">All</option>
            <option value="politics">politics</option>
            <option value="health">health</option>
            <option value="tech">tech</option>
            <option value="sport">sport</option>
            <option value="culture">culture</option>
        </select><br>
        <button type="submit">Add</button>
    </form>
    
   
</body>
</html>
