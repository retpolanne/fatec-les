<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="models.Usuarios" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<html>
    <head><title>Login</title></head>
    <body>
        <form action="/Jornal/Controller" method="GET">
            <button type="submit" name="cmd" value="listarUsuarios">
                Listar Usuários
            </button>
        </form>
        <ul>
            <%
                List<Usuarios> usuarios = (List<Usuarios>) session.getAttribute("usuarios");
                
                if (usuarios == null) {
                    usuarios = new ArrayList<Usuarios>();
                    session.setAttribute("usuarios", usuarios);
                }
                for (Usuarios usuario : usuarios) {
            %>
                <li>
                    <p>
                        Nome <%= usuario.getNome()%>
                    </p>
                </li>
            <% } %>
        </ul>
    </body>
</html>