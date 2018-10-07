<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="models.Jogo" %>
<%@ page import="controllers.JogosController" %>
<%@ page import="exceptions.GenericDAOException" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%
    List<String> difs = null;
    JogosController ctrl = new JogosController();
    String message = (String) session.getAttribute("message");
    try {
        difs = ctrl.showDificuldades();
    } catch (GenericDAOException e) {
    }
%>
<html>
    <head>
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Jogos</title>
    </head>
    <body>
        <nav>
            <div class="nav-wrapper container">
                <a href="#" class="brand-logo">Jogos</a>
            </div>
        </nav>
        <div class="container" id="jogo-mgmt">
            <h4>Gerenciar jogos</h4>
            <%
                Jogo jogo = (Jogo) session.getAttribute("jogoInfo");
                if (jogo == null) {
                    jogo = new Jogo();
                }
                String jogoDif = jogo.getDificuldade();
            %>
            <form action="/Jogos/JogosController" method="POST">
                <p>Nome: <input type="text" name="txtNome" value="<%= jogo.getNome()%>"/></p>
                <p> Dificuldade: 
                    <div class="input-field col s12">
                        <select class="browser-default" name="txtDif">
                            <option value="" disabled>Selecione a dificuldade do jogo</option>
                            <% for (String dif : difs) { %>
                                <% if (dif.equals(jogoDif)) { %>
                                    <option value="<%=dif%>" selected><%=dif%></option>
                                <% } else { %>
                                    <option value="<%=dif%>"><%=dif%></option>
                                <% } %>
                            <% } %>
                        </select>
                    </div>
                </p>
                <button class="btn waves-effect waves-light" type="submit" name="cmd" value="adicionar">
                    Adicionar
                </button>
            </form>
            <p>Status: <%=message %></p>
        </div>
        <div class="container" id="jogo-pesquisa">
            <h4>Pesquisar jogo</h4>
            <form action="/Jogos/JogosController" method="GET">
                Digite o nome do jogo: <input id="search" type="search" name="txtNome"/>
                <button class="btn waves-effect waves-light" type="submit" name="cmd" value="pesquisar">
                    Pesquisar 
                </button>
            </form>
        </div>
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    </body>
</html>