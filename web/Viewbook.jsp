<%-- 
    Document   : Viewbook
    Created on : May 8, 2020, 5:09:00 PM
    Author     : Teaser
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="entity.book"%>
<%@page import="entity.book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ArrayList<book> list=(ArrayList<book>)request.getAttribute("blist");
            if(list==null)
            {
                response.sendRedirect("Bookcontroller?ac=view");
            }
            else
            {
        %>
        <h1>Book List</h1>
        <a href="Addbook.jsp">Add New</a>
        <table border="1" width="60%">
            <tr>
                <th>ID Book</th>
                <th>Name Book</th>
                <th>Author Book</th>
                <th>Delete</th>
                <th>Edit</th>
                <th>Detail</th>
            </tr>
            <%
                for(book b:list)
                {
                    String id=b.getId();
                    String name=b.getName();
                    String au=b.getAuthor();
                    %>
                    <tr>
                        <td><%=id%></td>
                        <td><%=name%></td>
                        <td><%=au%></td>
                        <td>
                            <a href="Bookcontroller?ac=del&id=<%=id%>">Delete</a>
                        </td>
                        <td>
                            <a href="Bookcontroller?ac=edit&id=<%=id%>">Edit</a>
                        </td>
                        <td>
                            <a href="Bookcontroller?ac=detail&id=<%=id%>">Detail</a>
                        </td>
                    </tr>
                    <%
                }
            %>
        </table>
        <%
            }
        %>
    </body>
</html>
