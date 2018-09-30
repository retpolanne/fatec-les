package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import models.Usuario;
import controllers.CadastroController;
import exceptions.UserAlreadyExistsException;

public class CadastroServlet extends HttpServlet {
    private CadastroController cadastroController = new CadastroController();

    @Override
    public void doPost (
        HttpServletRequest request, HttpServletResponse response
    ) throws IOException, ServletException {
        String username = request.getParameter("txtLogin");
        String name = request.getParameter("txtNome");
        String email = request.getParameter("txtEmail");
        String telefone = request.getParameter("txtPhone");
        String password = request.getParameter("txtSenha");

        HttpSession session = request.getSession();
        PrintWriter htmlOut = response.getWriter();
        try {
            Usuario usuario = cadastroController.createNewUser(
                username, name, email, telefone, password
            );
            session.setAttribute("userInfo", usuario);
            session.setAttribute("loggedIn", true);
            session.setAttribute("userMessage", "User created successfully");
            response.sendRedirect("./index.jsp");
        } catch (UserAlreadyExistsException e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            session.setAttribute("userMessage", "Oops, user with this username already exists");
            response.sendRedirect("./cadastro.jsp");
        }
    }
}