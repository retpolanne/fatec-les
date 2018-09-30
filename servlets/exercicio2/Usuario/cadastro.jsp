<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>    
<html>
    <head>
        <title>Cadastro</title>
    </head>
    <body>
        <form action="./cadastro" method="POST">
            <h3>Sign up</h3>
            <p>User: <input type="text" name="txtLogin"/></p>
            <p>Name: <input type="text" name="txtNome"/></p>
            <p>Email: <input type="text" name="txtEmail"/></p>
            <p>Phone: <input type="text" name="txtPhone"/></p>
            <p>Password: <input type="text" name="txtSenha"/></p>
            <input type="submit" value="Submit"/>
        </form>
        <% 
            String userMessage = (String) session.getAttribute("userMessage");
        %>
        <h3><%=userMessage %></h3>
    </body>
</html>