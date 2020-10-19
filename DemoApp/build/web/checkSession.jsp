<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("Login.jsp");
    }
%>