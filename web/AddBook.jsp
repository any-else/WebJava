<%-- 
    Document   : AddBook
    Created on : May 8, 2020, 4:43:52 PM
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
        <h1>Enter Information</h1>
        <form method="Post" action="Bookcontroller?ac=add">
            BookID : <input type="text" name="txtID" size="10"/><br/>
            BookName : <input type="text" name="txtName" size="30"/><br/>
            Author : <br/>
            <select name="slAuthor">
                <option value="Teaser">Teaser</option>
                <option value="duc">duc</option>
                <option value="dai">dai</option>
                <option value="tai">tai</option>
                <option value="cong">cong</option>
                <select/>
            <br/>
            Price :<input type="text" name="txtPrice" size="10"/><br/>
            Description :<br/>
            <textarea name="taDes" rows="10" cols="30">Enter something in here</textarea>
            <input type="submit" value="AddBook"/>
        </form>
    </body>
</html>
