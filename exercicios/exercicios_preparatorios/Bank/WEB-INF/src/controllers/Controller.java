package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;

import models.Usuarios;
import models.Noticias;
import dao.UsuariosDao;
import dao.NoticiasDao;
import interfaces.UsuariosDaoInterface;
import interfaces.NoticiasDaoInterface;
import exceptions.GenericDAOException;

public class Controller extends HttpServlet {
    private static final Logger logger = Logger.getLogger(Controller.class.getName());
    private static final String loginJspPath = "/Jornal/Login";
    private static final String noticiasJspPath = "/Jornal/Noticias";
    private static final String jornalJspPath = "/Jornal/Jornal";
    private static final String erroJspPath = "/Jornal/Erro";

    @Override
    public void init (ServletConfig config) throws ServletException {
        super.init(config);
        logger.setLevel(Level.CONFIG);
    }

    @Override
    public void doGet (
        HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String cmd = request.getParameter("cmd");
        logger.log(Level.INFO, "Test");
        try {
            switch (cmd) {
                case "ping":
                logger.log(Level.INFO, "Making health check");
                response.setStatus(200);
                break;
                case "listarUsuarios":
                logger.log(Level.INFO, "Received get cmd listarUsuarios");
                List<Usuarios> usuarios = showUsuarios();
                session.setAttribute("usuarios", usuarios);
                response.sendRedirect(loginJspPath);
                break;
                default:
                logger.log(Level.INFO, "Received no cmd");
                response.sendRedirect(loginJspPath);
                break;
            }

        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logger.log(Level.SEVERE, "Error: " + e.getMessage() + " at line " + e.getStackTrace()[0].getLineNumber());
            response.sendRedirect(erroJspPath);
        }
    }

    @Override
    public void doPost (
        HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        String pathRedirect = "/";
        HttpSession session = request.getSession();
        String cmd = request.getParameter("cmd");
        try {

        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logger.log(Level.SEVERE, e.toString());
            response.sendRedirect(erroJspPath);
        }
        response.sendRedirect(pathRedirect);
    }

    @Override
    public void doPut (
        HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        String pathRedirect = "/";
        HttpSession session = request.getSession();
        String cmd = request.getParameter("cmd");
        try {

        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logger.log(Level.SEVERE, e.toString());
            response.sendRedirect(erroJspPath);
        }
        response.sendRedirect(pathRedirect);
    }

    @Override
    public void doDelete (
        HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        String pathRedirect = "/";
        HttpSession session = request.getSession();
        String cmd = request.getParameter("cmd");
        try {

        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logger.log(Level.SEVERE, e.toString());
            response.sendRedirect(erroJspPath);
        }
        response.sendRedirect(pathRedirect);
    }

    public List<Usuarios> showUsuarios () throws Exception {
        UsuariosDaoInterface dao = new UsuariosDao();
        List<Usuarios> usuarios;
        try {
            usuarios = dao.showAll();
        } catch (GenericDAOException e) {
            logger.log(Level.SEVERE, e.toString());
            throw e;
        }
        return usuarios;
    }

    public List<Noticias> showNoticias () throws Exception {
        NoticiasDaoInterface dao = new NoticiasDao();
        List<Noticias> noticias;
        try {
            noticias = dao.showAll();
        } catch (GenericDAOException e) {
            logger.log(Level.SEVERE, e.toString());
            throw e;
        }
        return noticias;
    }
}