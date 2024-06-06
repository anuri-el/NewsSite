<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
        <link rel="stylesheet" type="text/css" href="../css/style.css">
    </head>
    <body>
        <%@include file="header.jspf" %>
        
        <section>
            <h1>${message}</h1>
            <a href=".">Go to main page</a>
        </section>  
        <br>
        <%@include file="footer.jspf"%>
    </body>
</html>