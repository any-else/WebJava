<%-- 
    Document   : EditbookEL
    Created on : May 14, 2020, 11:52:28 AM
    Author     : Teaser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Enter New Information</h1>
        <jsp:useBean id="Teaser" scope="page" class="model.dataprocess"/>
        <c:set var="t" value="${requestScope['bDetail']}"/>
        <form method="Post" action="Bookcontroller?ac=update">
            BookID : <input type="text" value="${t.id}" name="txtID" size="10" readonly="true"/><br/>
            BookName : <input type="text" value="${t.name}" name="txtName" size="30"/><br/>
            Author :<br/>
            <select name="slAuthor">
                <c:forEach var="a" items="${Teaser.author}">
                    <option value="${a.id}">
                        ${a.name}
                    </option>
                </c:forEach>
            <select/>
            <br/>
            Price :<input type="text" name="txtPrice" value="${t.price}" size="10"/><br/>
            Description :<br/>
            <textarea name="taDes" rows="10" cols="30">${t.des}</textarea>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
