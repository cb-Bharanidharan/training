<%-- 
    Document   : login
    Created on : Dec 28, 2016, 12:50:32 PM
    Author     : bharanidharan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style>
            fieldset
            {
                position: absolute;
                top:20%;
                left:35%;
                width:30%;
                height:55%;
                
                
            }
           input[type="text"],input[type="password"]
           {
            width:300px;
            height:50px;
            margin-bottom: 20px;
            font-size: 1.1em;
            border: 0px;
            border-bottom: 3px solid;
            }
            input[type="submit"]
            {
            width:300px;
            height:50px;
            margin-bottom: 20px;
            font-size: 1.1em;
            border: 0px;
            color:white;
            background-color: #fd7375;
            }
            button
            {
                border: 0px;
                width:100%;
                height: 18%;
                background-color: #8792FC;
                
            }
            a
            {
                color:whitesmoke;
                text-decoration: none;
                font-size: 1.1em;
            }
        </style>
    </head>
    <body>
        <fieldset align="center">
            <h1>SPACE PORTAL</h1><h4>Login</h4>
            <form action="verify.jsp" method="POST">
                <input type="text" name="EMAIL" placeholder="Username" required><br>
                <input type="password" name="PASSWORD" placeholder="&#9679;&#9679;&#9679;&#9679;&#9679;&#9679;&#9679;&#9679;" required><br>
                <input type="submit" value="LOGIN">
                
               
        
              </form>
          
                <button><a href="signup.jsp">New around here?</a></button>
        </fieldset>
            </body>
</html>
