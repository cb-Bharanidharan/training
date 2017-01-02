<%-- 
    Document   : edit
    Created on : Dec 28, 2016, 3:02:10 PM
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
            background-color: #8792fc;
            color:white;
            padding-left: 10px;
            margin-right:10px;
            padding-bottom: 20px;
            font-family: sans-serif;
            text-align-last:end; 
            
        }
     ul
        {
           display:-webkit-inline-box;
        }
        table tr td a
        {
            color:graytext;
            padding-left:5px;
            text-decoration: underline;
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
         input[type="text"],input[type="email"],select
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
         input[type="email"]
         {
             background-color:rgba(128, 128, 128, 0.62);
             color:whitesmoke;
         }
         input[type="submit"]
         {
                  color:white;
                  background-color: #fd7375;
                  font-size: 0.8em;
                  text-align: center;
                  width:100px;
                  border:0px;
                  height: 50px;
                  border-radius: 5%;
         }
        </style>
            
    </head>
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
       <%try
            {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ss","root","");  
            Statement stmt=con.createStatement();
            String sql="select * from user where email like '"+session.getAttribute("USERID")+"'";
            ResultSet rs=stmt.executeQuery(sql);
            rs.next();
            
            if(request.getParameter("update")!=null)
            {
                sql="UPDATE user set firstname= '"+request.getParameter("FNAME")+"', "
                + "lastname='"+request.getParameter("LNAME")+"', "
                + "address='"+request.getParameter("ADDRESS")+"' "
                + "WHERE email like '"+session.getAttribute("USERID")+"'";
                
                    out.println(sql+"<br>");
            
                    
                stmt.executeUpdate(sql);
                
                response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location","home.jsp");
                
            }

            %>
            <h1 align="center">EDIT DETAILS</h1>
            <form action =" " method="POST">
                <table align="center">
                    <tr><td><label>FIRSTNAME</label></td><td><input type="text" name="FNAME" value="<%out.write(rs.getString("firstname")); %>" ></td></tr>
                <tr><td><label>LASTNAME</label></td><td><input type="text" name="LNAME" value="<%out.write(rs.getString("lastname")); %>" ></td></tr>
               <tr> <td><label>ADDRESS</label></td><td><input type="text" name="ADDRESS" value="<%out.write(rs.getString("address")); %>" ></td></tr>
               <tr><td><label>EMAIL</label></td><td> <input type="email"   readonly="" value="<%out.write(rs.getString("email")); %>" ></td></tr>
               <tr> <td></td><td><input type="submit" value="Save Details" name="update"><a href="home.jsp">Discard</a></td></tr>
                </table>
                
                
            </form>
            
            
            <%
            con.close();
            
            }
            catch(Exception e)
            {
              out.print(e);
                 //response.setStatus(response.SC_MOVED_TEMPORARILY);
            //response.setHeader("Location","login.jsp");
           
            }
        %>
    </body>
</html>
