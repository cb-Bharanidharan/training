<%-- 
    Document   : signup
    Created on : Dec 28, 2016, 11:09:42 AM
    Author     : bharanidharan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            td{
                width:230px;
                height: 80px;
            }
          h1,h4
          {
              color:graytext;
              font-family:  "Comic Sans MS", "Comic Sans", cursive;
              padding:auto;
          }
          a
          {
                 
                  color:graytext;
                  text-decoration: underline;
                  font-family:  "Comic Sans MS", "Comic Sans", cursive;
          
          }
          #sub
          {
                      margin-left: 38%;
                    width: 300px;
                    text-align: center;
                  color:whitesmoke;
                  border:1px solid white;
                  background-color: #FD7375;
              
          }
            input,select
         {
             color:graytext;
             border-radius: 5%;
             border:2px graytext solid;
             height: 50px;
             width:200px;
             font-size: 1.1em;
            text-align: left;
            padding-left: 10px;
         }
        </style> 
    </head>
    <body>
        <%
            if(request.getParameter("id")!=null)
            {
             out.print(" <script type=\"text/javascript\">"
                     + "var msg = \"EMAIL  ALREADY PRESENT\";"
                     + "alert(msg);"
                     + "window.location=\"signup.jsp\"</script>");
             //response.setStatus(response.SC_MOVED_TEMPORARILY);
              //  response.setHeader("Location","signup.jsp");

            }
            %>
        <h4 align="center">Register to</h4>
        <h1 align="center">SPACE PORTAL</h1>
        <form action="insert.jsp" method="GET" onsubmit="return validate()">
            <table align="center">
                <tr>
                    <td><input type="text" name="FNAME" placeholder="FIRSTNAME" required></td>
                    <td> <input type="text" name="LNAME" placeholder="LASTNAME" required></td>
                </tr>
                <tr> 
                    <td><input type="email" name="EMAIL" placeholder="EMAIL" required></td>
                    <td><input type="email" name="CEMAIL" placeholder="CONFIRM MAIL" required></td>
                </tr>
                <tr>
                    <td><input type="password" name="PASSWORD" placeholder="PASSWORD" required ></td>
                    <td><input type="password" name="CPASSWORD" placeholder="CONFIRM PASSWORD" required></td>
                </tr>
               
            </table>
            <input id="sub" type="submit" value="Create an Account" />
            <br>
            
        </form>
        <h5 align="center">   <a  href="login.jsp">Have an account already?</a></h5>
    </body>
    
    
    <script type="text/javascript">
        function validate()
        {
            var e1=document.getElementsByName("EMAIL")[0].value;
            var e2=document.getElementsByName("CEMAIL")[0].value;
            var p1=document.getElementsByName("PASSWORD")[0].value;
            var p2=document.getElementsByName("CPASSWORD")[0].value;
            if(e1!=e2)
            {
                alert("MAIL ID DOESNT MATCH");
                return false;
            }
            else if(p1!=p2)
            {
                alert("PASSWORD DOESNT MATCH");
                return false;
            } 
           return true;
           
        }
                </script>
</html>
