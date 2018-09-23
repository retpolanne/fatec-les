package controllers;

import utils.Security;
import exceptions.UnauthorizedUserException;
import models.Usuario;
import dao.UsuariosDao;
import interfaces.UsuariosDaoInterface;

public class LoginController {

    private Usuario usuario;
    private UsuariosDaoInterface usuarioDao = new UsuariosDao();
    private Security secUtils = new Security();

    public Usuario makeLogin (String username, String password) throws UnauthorizedUserException {
        if (password == null) {
            throw new UnauthorizedUserException(
                "The password was null"
            );
        }
        if (username == null) {
            throw new UnauthorizedUserException(
                "The username was null"
            );
        }
        password = secUtils.hashPassword(password);
        Usuario foundUser = usuarioDao.search(username, password);
        if (foundUser == null) {
            throw new UnauthorizedUserException(
                "User not found with this combination of username and password"
            );
        }
        return foundUser;
    }
}