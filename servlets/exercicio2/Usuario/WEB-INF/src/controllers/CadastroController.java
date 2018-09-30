package controllers;

import utils.Security;
import exceptions.UserAlreadyExistsException;
import models.Usuario;
import dao.UsuariosDao;
import interfaces.UsuariosDaoInterface;

public class CadastroController {

    private Usuario usuario;
    private UsuariosDaoInterface usuarioDao = new UsuariosDao();
    private Security secUtils = new Security();

    public Usuario createNewUser (
        String username, String name, String email, String telefone, String password
    ) throws UserAlreadyExistsException {
        password = secUtils.hashPassword(password);

        Usuario user = new Usuario();
        user.setUsuario(username);
        user.setNome(name);
        user.setEmail(email);
        user.setTelefone(telefone);
        user.setPassword(password);

        String userName = usuarioDao.create(user);
        if (userName == null) {
            throw new UserAlreadyExistsException("A user with this username already exists!");
        }
        return user;
    }
}