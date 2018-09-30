package servlets;

import javax.lang.model.util.ElementScanner6;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import models.Aluno;
import java.util.List;
import controllers.AlunoController;
import exceptions.GenericDAOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunoServlet extends HttpServlet {
    private AlunoController alunoController = new AlunoController();
    private List<Aluno> alunos;

    @Override
    public void init (ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        try {
            alunos = alunoController.showAll();
            context.setAttribute("message", "Lista criada");
            context.setAttribute("alunoList", this.alunos);
        } catch (GenericDAOException e) {
            context.setAttribute("message", "Erro criando lista de alunos");
        }
    }

    @Override
    public void doGet( 
        HttpServletRequest request, HttpServletResponse response
    ) throws IOException, ServletException {
        HttpSession session = request.getSession();
        try {
            alunos = alunoController.showAll();
            session.setAttribute("alunoList", this.alunos);
        } catch (GenericDAOException e) {
            session.setAttribute("message", "Erro criando lista de alunos");
        }

        String cmd = request.getParameter("cmd");
        
        if (cmd != null) {
            String idTxt = request.getParameter("txtId");
            if (idTxt == null)
                idTxt = "0";
            long id = Long.parseLong(idTxt);
            Aluno aluno = new Aluno();
            if (id != 0)
                aluno.setId(id);
            else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                session.setAttribute("message", "Algo deu errado!");
            }
            switch (cmd) {
                case "pesquisar":
                    try {
                        aluno = alunoController.search(id);
                        session.setAttribute("alunoInfo", aluno);
                        if (aluno != null)
                            session.setAttribute("message", "Aluno encontrado");
                        else
                            session.setAttribute("message", "Aluno não encontrado");
                    } catch (GenericDAOException e) {
                        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                        session.setAttribute("message", "Erro pesquisando aluno");
                    }
                    break;
                default:
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    session.setAttribute("message", "Algo deu errado!");
            }
        }
        ServletContext sc = this.getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/aluno.jsp");
        rd.include(request, response);
    }

    @Override
    public void doPost (
        HttpServletRequest request, HttpServletResponse response
    ) throws IOException, ServletException {
        String idTxt = request.getParameter("txtId");
        if (idTxt == null)
            idTxt = "0";
        long id = Long.parseLong(idTxt);
        String ra = request.getParameter("txtRa");
        String nome = request.getParameter("txtNome");
        String idadeTxt = request.getParameter("txtIdade");
        if (idadeTxt == null)
            idadeTxt = "0";
        int idade = Integer.parseInt(idadeTxt);
        String sexo = request.getParameter("txtSexo");

        Aluno aluno = new Aluno();
        if (id != 0)
            aluno.setId(id);
        if (ra != null) {
            if (!ra.isEmpty())
                aluno.setRa(ra);
        }
        if (nome != null) {
            if (!nome.isEmpty())
                aluno.setNome(nome);
        }
        if (idade != 0)
            aluno.setIdade(idade);
        if (sexo != null) {
            if (!sexo.isEmpty())
                aluno.setSexo(sexo);
        }

        HttpSession session = request.getSession();

        String cmd = request.getParameter("cmd");
        
        if (cmd == null) {
            session.setAttribute("message", "Algo deu errado! Cmd nulo");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            switch (cmd) {
                case "adicionar":
                    try {
                        alunoController.createAluno(aluno);
                        session.setAttribute("message", "Aluno criado com sucesso");
                    } catch (GenericDAOException e) {
                        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                        session.setAttribute("message", "Erro ao criar registro aluno");
                    }
                    break;
                case "atualizar":
                    try {
                        alunoController.updateAluno(aluno);
                        session.setAttribute("message", "Aluno atualizado com sucesso");
                    } catch (GenericDAOException e) {
                        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                        session.setAttribute("message", "Erro ao atualizar registro aluno");
                    }
                    break;
                case "remover":
                    try {
                        alunoController.delete(id);
                        session.setAttribute("message", "Aluno removido com sucesso");
                    } catch (GenericDAOException e) {  
                        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                        session.setAttribute("message", "Erro ao remover aluno");
                    }
                    break;
                default:
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    session.setAttribute("message", "Algo deu errado!" + cmd);
            }
            this.doGet(request, response);
        }
    }
}