package interfaces;

import models.Usuario;

public interface UsuariosDaoInterface {
    public Usuario search (String usuario, String password);
    public String create (Usuario usuario);
}