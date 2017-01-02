<%-- 
    Document   : logout
    Created on : Dec 28, 2016, 3:49:33 PM
    Author     : bharanidharan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            session.invalidate();
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location","home.jsp");
        %>
    </body>
</html>
