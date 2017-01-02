<%-- 
    Document   : home
    Created on : Dec 28, 2016, 2:21:57 PM
    Author     : bharanidharan
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style>
      
            h1{
                
            }
         th{
             font-family:sans-serif;
            padding: 10px;
            text-transform: uppercase;
            text-align: left;
            color:white;
        background-color: rgba(103, 58, 183, 0.79);
        }
        td
        {
            font-family:Arial, Helvetica,sans-serif;
            padding: 10px;
            text-align: center;
           
            color:black;
        }
        tr
        {
            border-bottom: 10px;
            border-style: solid;
            border-bottom-color: gray;
            
        }
        a
        {
            text-decoration: none;
            color:black;
        }
        #log
        {
            color:white;
        }
        .odd
        {
        background-color: white;
 
        }
        .even
        {
         background-color: rgba(128, 128, 128, 0.38);
        }
        .header
        {
           width:100%;
           height: 50px !important;
            background-color: #8792fc;
            color:white;
            padding-left: 10px;
            margin-right:10px;
            padding-bottom: 20px;
            font-family: sans-serif;
            text-align-last:end; 
            
        }
    
        div.right
        {
            float:right;
            padding-right:10px;
           
            
        }
        ul
        {
           display:-webkit-inline-box;
        }
        li
        {
         display:-webkit-inline-box;
         margin-left: 20px;
         margin-right:10px;
        }
        ul li a
        {
            color:whitesmoke;
        }
        a
        {
            text-transform:capitalize;  
            color:whitesmoke;
        }
        .edit
        {
            width:300px;
            height:50px;
            margin-bottom: 20px;
            font-size: 1.1em !important;
            border: 0px;
            color:white;
            background-color: #fd7375;
        }
    </style>
    </head>
      <%
                if(session.getAttribute("USERID")==null)
                {
                    response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location","login.jsp");
                }
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ss","root","");  
            Statement stmt=con.createStatement();
            String sql="select * from user where email like '"+session.getAttribute("USERID")+"'";
            ResultSet rs=stmt.executeQuery(sql);
            rs.next();
                 %>
                
    <body>
        <div class="header">
                <ul >
                    <li><h4>Hello <% 
            
            out.print(session.getAttribute("UNAME"));
            %>,</h4></li>
                    <li><h4 ><a href="dacv.jsp">DEACTIVATE ACCOUNT</a></h4></li>
                    <li><h4 ><a href="logout.jsp">Logout</a></h4></li>
                </ul>
            </div>
                    <table align="center">             
                        <tr><td><h1>WELCOME TO SPACE PORTAL</h1></td></tr>
                        <tr><td><% out.print("Name:"+rs.getString("firstname")+" "+rs.getString("lastname"));%></td></tr>
                        <tr><td><% out.print("Email:"+rs.getString("email"));%></td></tr>
                        <tr><td><% out.print("Address:"+rs.getString("address"));%></td></tr>
                        <tr><td><button class="edit"><a  href="edit.jsp">edit details</a></button></td></tr>
                    </table>
                
         <%   
                }
                catch(Exception e)
                {
                }
%>
    </body>
</html>
