<%-- 
    Document   : dacv
    Created on : Dec 28, 2016, 4:39:39 PM
    Author     : bharanidharan
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <%
            try
            {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ss","root","");  
            Statement stmt=con.createStatement();
            String sql="delete from user where email like '"+session.getAttribute("USERID")+"'";
           stmt.execute(sql);
            con.close();
            session.invalidate();
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location","home.jsp");
            }
            catch(Exception e)
            {
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location","login.jsp");
           
            }
        %>
    </body>
</html>
