<%-- 
    Document   : index
    Created on : Dec 28, 2016, 11:03:21 AM
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
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location","login.jsp");
            %>
    </body>
</html>
