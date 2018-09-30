<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <form action="./login" method="POST">
            <h3>Input your login</h3>
            <input type="text" name="txtLogin"/>
            <input type="text" name="txtSenha"/>
            <input type="submit" value="Submit"/>
        </form>
        <% 
            String userMessage = (String) session.getAttribute("userMessage");
        %>
        <h3><%=userMessage %></h3>
    </body>
</html>