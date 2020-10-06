<%-- 
    Document   : Home
    Created on : May 8, 2020, 2:06:10 PM
    Author     : Teaser
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String User=(String) request.getAttribute("User");
            if(User == null)
            {
                response.sendRedirect("Login.jsp");
            }
            else
            {
        %>
        <h1>Hello welcome <%=User%> to website!</h1>
        
        <%
            }
        %>
    </body>
</html>
