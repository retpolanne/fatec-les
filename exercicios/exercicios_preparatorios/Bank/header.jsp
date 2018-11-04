<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="models.Usuarios" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<html>
    <head><title>Banco Fatec - BFZL</title></head>
    <body>
        <% 
            String mensagem = (String) session.getAttribute("mensagem");
            String idUsuario = "Não Logado"
            if (mensagem == null) {
                mensagem = "";
            }
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            if (usuario == null) {
                usuario = new Usuario();
            } else {
                idUsuario = (String) usuario.getId();
            }
        %>
        <h1>Banco Fatec - BFZL</h1>
        <h3>Mensagem: <%= mensagem %></h3>
        <h3>Cliente: <%= idUsuario %></h3>
    </body>
</html>