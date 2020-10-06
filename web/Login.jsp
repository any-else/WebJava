<%-- 
    Document   : Login
    Created on : May 8, 2020, 2:14:04 PM
    Author     : Teaser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login in us website</h1>
        <form method="POST" action="controller">
            User : <input type="text" name="txtuser" size="30"/><br/>
            Pass : <input type="password" name="txtpass" size="30"/><br/>
            <input type="submit" value="Login"/>
            <input type="reset" value="Clear"/>
        </FORM>
    </body>
</html>
