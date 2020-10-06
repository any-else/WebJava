<%-- 
    Document   : AddBookEL
    Created on : May 14, 2020, 10:35:52 AM
    Author     : Teaser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Enter Information</h1>
        <jsp:useBean id="Teaser" scope="page" class="model.dataprocess"/>
        <form method="Post" action="Bookcontroller?ac=add">
            BookID : <input type="text" name="txtID" size="10"/><br/>
            BookName : <input type="text" name="txtName" size="30"/><br/>
            Author :<br/>
            <select name="slAuthor">
                <c:forEach var="a" items="${Teaser.author}">
                    <option value="${a.id}">
                        ${a.name}
                    </option>
                </c:forEach>
            <select/>
            <br/>
            Price :<input type="text" name="txtPrice" size="10"/><br/>
            Description :<br/>
            <textarea name="taDes" rows="10" cols="30">Enter something in here</textarea>
            <input type="submit" value="AddBook"/>
        </form>
    </body>
</html>
