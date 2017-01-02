<%-- 
    Document   : index
    Created on : Dec 29, 2016, 10:55:58 AM
    Author     : bharanidharan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(request.getParameter("sub")!=null)
            {
                String user=request.getParameter("user");
                String pass=request.getParameter("pass");
                if(user.equals("admin") && pass.equals("admin"))
                {
                    session.setAttribute("USER","PHONE DIRECTORY");
                    response.setStatus(response.SC_MOVED_TEMPORARILY);
                     response.setHeader("Location","home.jsp");
                }
                
            }

            %>
        
        <form action=" " method="post">
            <fieldset>
                <legend>login</legend>
                <input type="text" name="user" required>
                <input type="password" name="pass" required>
                <input type="submit" value="login" name="sub">
                
            </fieldset>
            
            
        </form>
    </body>
</html>
