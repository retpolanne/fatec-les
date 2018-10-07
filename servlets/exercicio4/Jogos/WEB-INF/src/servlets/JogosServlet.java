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
import models.Jogo;
import models.Dificuldade;
import java.util.List;
import controllers.JogosController;
import exceptions.GenericDAOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JogosServlet extends HttpServlet {
    private JogosController jogosController = new JogosController();
    private List<String> difs;

    @Override
    public void init (ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        try {
            difs = jogosController.showDificuldades();
            context.setAttribute("message", "Lista criada");
            context.setAttribute("difsList", this.difs);
        } catch (GenericDAOException e) {
            context.setAttribute("message", "Erro criando lista de dificuldades");
        }
    }

    @Override
    public void doGet( 
        HttpServletRequest request, HttpServletResponse response
    ) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String cmd = request.getParameter("cmd");
        String nome = request.getParameter("txtNome");
        switch (cmd) {
            case "pesquisar":
                try {
                    Jogo jogo = jogosController.searchJogo(nome);
                    if (jogo != null) {
                        session.setAttribute("message", "Jogo encontrado");
                        session.setAttribute("jogoInfo", jogo);
                    }
                    else
                        session.setAttribute("message", "Jogo não encontrado");
                } catch (GenericDAOException e) {
                    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    session.setAttribute("message", "Erro pesquisando jogo");
                }
                break;
            default:
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                session.setAttribute("message", "Algo deu errado no cmd! Cmd enviado " + cmd); 
        }
        response.sendRedirect("/Jogos");
    }

    @Override
    public void doPost (
        HttpServletRequest request, HttpServletResponse response
    ) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String cmd = request.getParameter("cmd");
        String nome = request.getParameter("txtNome");
        String dificuldade = request.getParameter("txtDif");
        switch (cmd) {
            case "adicionar":
                try {
                    Jogo jogo = new Jogo();
                    jogo.setNome(nome);
                    jogo.setDificuldade(dificuldade);
                    jogosController.createJogo(jogo);
                    session.setAttribute("message", "Jogo criado com sucesso");
                } catch (GenericDAOException e) {
                    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    session.setAttribute("message", "Erro criando jogo");
                }
                break;
            default:
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                session.setAttribute("message", "Algo deu errado no cmd! Cmd enviado " + cmd); 
        }
        response.sendRedirect("/Jogos");
    }
}