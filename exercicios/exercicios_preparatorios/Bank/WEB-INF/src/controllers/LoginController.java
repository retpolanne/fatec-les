package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import java.io.IOException;

public class LoginController extends HttpServlet {
    @Override
    public void doPost(
        HttpServletRequest request, HttpServletResponse response
    ) throws IOException, ServletException {
        String cmd = request.getParameter("cmd");
        switch (cmd) {
            default:
                logger.log(Level.INFO, "Received no cmd");
                response.setStatus(400);
                break;
        }
    }
}