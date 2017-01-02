<%-- 
    Document   : home
    Created on : Dec 29, 2016, 11:07:25 AM
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
             font-family:Arial, Helvetica,sans-serif;
             margin-left: 10%;
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
    </style>
    <body>
       
            <div  class="header">
                <br>
               PHONE DIRECTORY
               <div class="right"><a id="log" href="index.jsp">Logout</a></div>
            </div>
        
        <section>
            <h1>ALL CONTACTS</h1>
        <table align="center" cellspacing="0">
            <tr>
                <th>NAME</th>
                <th>ADDRESS</th>
                <th>PHONE</th>
                <th></th>
                <th></th>
            </tr>
            <%
                  try
            {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pd","root","");  
            Statement stmt=con.createStatement();
            String sql="select * from phone ";
            ResultSet rs=stmt.executeQuery(sql);
            int count=0;
            while(rs.next())
            {
                 count++;
                out.println("<tr ");
                if(count%2==0)
                    out.print("class=\"even\"");
                else
                    out.print("class=\"odd\"");
                out.println(">"
                
                        + "<td><a href=\"edit.jsp?id="+count+"\">"+rs.getString("name")+" "+rs.getString("lname")+"</a></td>"
                        + "<td>"+rs.getString("alane1")+rs.getString("alane2")+rs.getString("address")+rs.getString("state")+rs.getString("pincode")+rs.getString("country")+"</td>"
                        + "<td>"+rs.getString("mobile")+"(Mobile)</td>"
                        + "<td>"+rs.getString("home")+"(Home)</td>"
                        + "<td>"+rs.getString("work")+"(Work)</td>"
                        + "</tr>");
                               

            }
            
            }
                  catch(Exception e)
                  {
                      out.print(e);
                  }
                %>
        </table>
        </section>
    </body>
</html>
