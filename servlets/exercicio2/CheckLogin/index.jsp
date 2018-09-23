<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="models.Usuario" %>
<html>
    <head>
        <title>Usuarios</title>
    </head>
    <body>
        <form action="./login" method="POST">
            <h3>Input your login</h3>
            <input type="text" name="txtLogin"/>
            <input type="text" name="txtSenha"/>
            <input type="submit" value="Submit"/>
        </form>

        <div>
            <% 
                Usuario user = (Usuario) session.getAttribute("userInfo");
                if (user == null) {
                    session.setAttribute("userInfo", null);
                    session.setAttribute("loggedIn", false);
                    session.setAttribute("userMessage", "Waiting for user login...");
                }
                boolean loggedIn = (boolean) session.getAttribute("loggedIn");
                String userMessage = (String) session.getAttribute("userMessage");
            %>
            <h3><%=userMessage %></h3>
            <% if (loggedIn) { %>
                <div>
                    <p>Username: <%=user.getUsuario() %> </p>    
                    <p>Nome: <%=user.getNome() %> </p>
                    <p>Email: <%=user.getEmail() %> </p>
                    <p>Telefone: <%=user.getTelefone() %> </p>
                    <p>Perfil: <%=user.getPerfil() %> </p>
                </div>
            <% } %>
        </div>
    </body>
</html>