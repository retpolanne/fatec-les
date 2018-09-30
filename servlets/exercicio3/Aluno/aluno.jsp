<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="models.Aluno" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<html>
    <head>
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Alunos</title>
    </head>
    <body>
        <nav>
            <div class="nav-wrapper container">
                <a href="#" class="brand-logo">Alunos</a>
            </div>
        </nav>
        <div class="container" id="aluno-mgmt">
            <h4>Gerenciar aluno</h4>
            <%
                Aluno aluno = (Aluno) session.getAttribute("alunoInfo");
                if (aluno == null) {
                    aluno = new Aluno();
                }
            %>
            <form action="/Aluno" method="POST">
                <p>ID: <input type="text" name="txtId" value="<%= aluno.getId()%>"/></p>
                <p>RA: <input type="text" name="txtRa" value="<%= aluno.getRa()%>"/></p>
                <p>Nome: <input type="text" name="txtNome" value="<%= aluno.getNome()%>"/></p>
                <p>Idade: <input type="text" name="txtIdade" value="<%= aluno.getIdade()%>"/></p>
                <p>Sexo: <input type="text" name="txtSexo" value="<%= aluno.getSexo()%>"/></p>
                <button class="btn waves-effect waves-light" type="submit" name="cmd" value="adicionar">
                    Adicionar
                </button>
                <button class="btn waves-effect waves-light" type="submit" name="cmd" value="atualizar">
                    Atualizar
                </button>
                <button class="btn waves-effect waves-light"ut type="submit" name="cmd" value="remover">
                    Remover
                </button>
            </form>
            <% String message = (String) session.getAttribute("message"); %>
            <p>Status: <%=message %></p>
        </div>
        <div class="container" id="aluno-pesquisa">
            <h4>Pesquisar aluno</h4>
            <form action="/Aluno" method="GET">
                Digite o ID: <input id="search" type="search" name="txtId"/>
                <button class="btn waves-effect waves-light" type="submit" name="cmd" value="pesquisar">
                    Pesquisar 
                </button>
            </form>
        </div>
        <div class="container" id="aluno-lista">
            <h4>Lista de alunos</h4>
            <ul class="collection">
                <%
                    List<Aluno> alunos = (List<Aluno>) session.getAttribute("alunoList");
                    
                    if (alunos == null) {
                        alunos = new ArrayList<Aluno>();
                        session.setAttribute("alunoList", alunos);
                    }
                    for (Aluno alunoItem : alunos) {
                %>
                    <li class="collection-item avatar">
                        <span class="title"><h5><%= alunoItem.getNome()%></h5></span>
                        <p>
                            ID <%= alunoItem.getId()%><br>
                            RA <%= alunoItem.getRa()%><br>
                            Idade <%= alunoItem.getIdade()%><br>
                            Sexo <%= alunoItem.getSexo()%>
                        </p>
                    </li>
                <% } %>
            </ul>
        </div>
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    </body>
</html>