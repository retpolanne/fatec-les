package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import models.Usuario;
import controllers.LoginController;
import exceptions.UnauthorizedUserException;

public class LoginServlet extends HttpServlet {
    private LoginController loginController = new LoginController();

    @Override
    public void doPost (
        HttpServletRequest request, HttpServletResponse response
    ) throws IOException, ServletException {
        String username = request.getParameter("txtLogin");
        String password = request.getParameter("txtSenha");

        HttpSession session = request.getSession();
        PrintWriter htmlOut = response.getWriter();
        try {
            Usuario usuario = loginController.makeLogin(username, password);
            session.setAttribute("userInfo", usuario);
            session.setAttribute("userMessage", "User was found!");
            session.setAttribute("loggedIn", true);
            response.sendRedirect("./index.jsp");
        } catch (UnauthorizedUserException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            session.setAttribute(
                "userMessage",
                "Oops, user was not found! " + 
                "Would you like to <a href=/Usuario/cadastro.jsp>sign up</a>?"
            );
            session.setAttribute("loggedIn", false);
            response.sendRedirect("./login.jsp");
        }
    }
}