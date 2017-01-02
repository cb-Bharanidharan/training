<%-- 
    Document   : edit
    Created on : Dec 29, 2016, 11:31:29 AM
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
         .header
        {
           width:100%;
           height: 50px !important;
            background-color: #9DCCA8;
            color:white;
            padding-left: 10px;
            padding-right:10px;
            font-family: sans-serif;
            
        }
        div.right
        {
            float:right;
            padding-right:10px;
           
            
        }
        h1{
             font-family:sans-serif;
             margin-left: 10%;
             color:graytext;
         }
         #dis
         {
             color:gray;
             text-decoration:underline;
             margin-left: 5px;
         }
         a
         {
         color:white;
         text-decoration: none;
         }
         label
         {
             font-family: sans-serif;
             color:graytext;
             
            
         }
         tr
         {
             border-bottom: 40px;
         }
         input[type="text"],select
         {
             color:graytext;
             border-radius: 5%;
             border:1px black solid;
             height: 50px;
             width:200px;
             font-size: 1.1em;
            text-align: left;
            padding-left: 10px;
         }
         #al1,#al2,#work,#mob,#home
         {
             width:420px;
         }
         input[type="submit"]
         {
                  color:white;
                  background-color: #8A91C3;
                  font-size: 1.1em;
                  text-align: center;
                  width:200px;
                  height: 50px;
                  border-radius: 5%;
         }
    </style>
    </head>
    <body>
        
          <div  class="header">
                <br>
               PHONE DIRECTORY
               <div class="right"><a href="index.jsp">Logout</a></div>
            </div>
        <h1>
            EDIT CONTACT
        </h1>
        <%
                  
            try
            {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pd","root","");  
            Statement stmt=con.createStatement();
            String sql="select * from phone where id="+request.getParameter("id");
            session.setAttribute("ID",request.getParameter("id"));
            ResultSet rs=stmt.executeQuery(sql);
            rs.next();
            
           %>
        <form  action="update.jsp" method="POST">
            <table align="center">
                <tr><td
                        align="right"><label>NAME</label></td><td><input type="text" name="fname" value="<%out.print(rs.getString("name"));%>" >
                    <input type="text" name="lname" value="<%out.print(rs.getString("lname"));%>"></td></tr>
            <tr>
                <td><label>ADDRESS</label></td>
                <td><input type="text" id="al1" name="al1" value="<%out.print(rs.getString("alane1"));%>"></td>
            </tr>
            <tr><td/>
                <td><input type="text" id="al2" name="al2" value="<%out.print(rs.getString("alane2"));%>"></td>
            </tr>
            <tr><td/>
                <td><input type="text" name="addr" value="<%out.print(rs.getString("address"));%>">
                <select name="st" required>
                <option disabled selected value>STATE</option>
                <option>TN</option>
                <option>KL</option>
                <option>AP</option>
                    </select></td>
            </tr>
            
            <tr><td/>
                <td><input type="text" name="pin" value="<%out.print(rs.getString("pincode"));%>">
                <select name="ct">
                 <option disabled selected value>COUNTRY</option>
                <option>IND</option>
                    </select></td>
            </tr>
            <tr>
                <td><label>PHONE(MOBILE)</label></td>
                <td><input id="mob" type="text" name="mob" value="<%out.print(rs.getString("mobile"));%>"></td>
            </tr>
            <tr>
                <td><label >PHONE(HOME)</label></td>
                <td><input id="home" type="text" name="home" value="<%out.print(rs.getString("home"));%>"></td>
            </tr>
            <tr><td><label>PHONE(WORK)</label></td>
                <td><input id="work" type="text" name="work" value="<%out.print(rs.getString("work"));%>"></td>
            </tr>
            <tr><td/><td> <input type="submit" value="Save Details"><a href="home.jsp" id="dis">Discard</a></td></tr>
            </table>
            <%
                }
                catch(Exception e)
                {
                    out.print(e);
                }
                %>
        </form>
        
        
        
        
    </body>
</html>
