<%-- 
    Document   : insert
    Created on : Dec 28, 2016, 1:41:51 PM
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
            ResultSet rs;
            String sql="INSERT INTO user(firstname,lastname,email,password,address) VALUES(?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,request.getParameter("FNAME"));
            ps.setString(2,request.getParameter("LNAME"));
            ps.setString(3,request.getParameter("EMAIL"));
            ps.setString(4,request.getParameter("PASSWORD"));
            ps.setString(5,"NULL");
            ps.execute();
            con.close();
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location","index.jsp");
            }
            catch(Exception e)
            {
                boolean a=e.toString().contains("Duplicate entry");
                if(a)
                {
               response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location","signup.jsp?id=1");
                }
            }
        %>
    </body>
</html>
