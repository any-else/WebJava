<%-- 
    Document   : ViewbookEL
    Created on : May 14, 2020, 11:27:02 AM
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
        <c:if test="${empty sessionScope['Teaser']}">
            <jsp:forward page="Login.jsp"/>
        </c:if>
        <c:choose>
            <c:when test="${empty requestScope['blist']}">
                <jsp:forward page="Bookcontroller?ac=view"/>
            </c:when>
            <c:otherwise>
                <h1>Book List</h1>
                <table border="1" width="60%">
                    <tr>
                        <th>Book ID</th>
                        <th>Book Name</th>
                        <th>Book Price</th>
                        <th>Book Delete</th>
                        <th>Book Edit</th>
                        <th>Book Detail</th>
                    </tr>
                    <jsp:useBean id="Teaser" scope="page" class="model.dataprocess"/>
                    <c:forEach var="t" items="${Teaser.data}">
                        <tr>
                            <td>${t.id}</td>
                            <td>${t.name}</td>
                            <td>${t.price}</td>
                            <td><a href="Bookcontroller?ac=del&id=${t.id}">Delete</a></td>
                            <td><a href="Bookcontroller?ac=edit&id=${t.id}">Edit</a></td>
                            <td><a href="Bookcontroller?ac=detail&id=${t.id}">Detail</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>
    </body>
</html>
