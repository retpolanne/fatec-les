<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="models.Usuario" %>
<html>
    <head>
        <title>Usuarios</title>
    </head>
    <body>
        <div>
            <% 
                Usuario user = (Usuario) session.getAttribute("userInfo");
                if (user == null) {
                    session.setAttribute("userInfo", null);
                    session.setAttribute("loggedIn", false);
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
                </div>
            <% } else { %>
                <h3>Redirecting to login...</h3>
                <script>
                    window.location.href = "/Usuario/login.jsp"
                </script>
            <% } %>
            <h3>Click <a href="/Usuario/login.jsp">here</a> to log in</h3>
            <h3>Click <a href="/Usuario/cadastro.jsp">here</a> to sign up</h3>
        </div>
    </body>
</html>