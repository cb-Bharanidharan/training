<%-- 
    Document   : addr
    Created on : Dec 28, 2016, 3:01:52 PM
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
    
    <%
          try
            {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ss","root","");  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("SELECT * FROM user where email like "
                    + "'"+session.getAttribute("USERID")+"'");
            
                rs.next();
            
                if(rs.getString("address")!=null)
                {
                    response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location","home.jsp");
             out.write("<script language=\"javascript\"> alert(\"ADDRESS ALREADY PRESENT N \");<script>");
                   
                }
              
            if(request.getParameter("addr")!=null)
            {
            String sql="UPDATE user set address ='"+request.getParameter("addr")+"' where email like "
                    + "'"+session.getAttribute("USERID")+"'";
                               stmt.execute(sql);
            con.close();
             out.write("<script language=\"javascript\"> alert(\"ADDRESS ADDED N \");<script>");
                           
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location","home.jsp");
            }
            
            }
            catch(Exception e)
            {
                out.println(e);
                
            }
        %>
    <body>
        <form action=" " method="POST">
            <fieldset>
                <legend>ADDRESS PANEL</legend>
            <input type="text" name="addr" required/>
            <input type="submit" value="ADD ADDRESS">
            </fieldset>
        </form>
    </body>
</html>
