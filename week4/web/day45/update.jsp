<%-- 
    Document   : update
    Created on : Dec 29, 2016, 12:45:37 PM
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
        <%try
            {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pd","root","");  
            Statement stmt=con.createStatement();
            String sql="UPDATE PHONE "
                    + "SET "
                    + "name='"+request.getParameter("fname")+"',"
                    + "lname='"+request.getParameter("lname")+"',"
                    + "alane1='"+request.getParameter("al1")+",',"
                    + "alane2='"+request.getParameter("al2")+",',"
                    + "address='"+request.getParameter("addr")+",',"
                    + "state='"+request.getParameter("st")+",',"
                    + "pincode='"+request.getParameter("pin")+",',"
                    + "country='"+request.getParameter("ct")+"',"
                    + "mobile='"+request.getParameter("mob")+"',"
                    + "home='"+request.getParameter("home")+"',"
                    + "work='"+request.getParameter("work")+"'"
                    + "where id ="+session.getAttribute("ID");
            stmt.executeUpdate(sql);
            con.close();
            session.invalidate();
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location","home.jsp");
            }
            catch(Exception e)
            {
                out.print(e);
            }
            %>
    </body>
</html>
