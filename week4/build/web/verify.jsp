<%-- 
    Document   : verify
    Created on : Dec 28, 2016, 2:15:34 PM
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
            String sql="select * from user where email like '"+request.getParameter("EMAIL")+"' and password like '"+request.getParameter("PASSWORD")+"'";
            ResultSet rs=stmt.executeQuery(sql);
            rs.next();
            
            if(!rs.getString("password").equals(request.getParameter("PASSWORD")))
            {
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location","login.jsp");
            }
 
                       session.setAttribute("USERID",request.getParameter("EMAIL"));
            session.setAttribute("UNAME",rs.getString("firstname")+" "+rs.getString("lastname"));
 
            con.close();
            
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location","home.jsp");
            }
            catch(Exception e)
            {
                out.print("<script language=\"text/javascript\"> alert(\"INVALID USERNAME PASSWORD \");<script>");

                 response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location","login.jsp");
           
            }
        %>
    </body>
</html>
