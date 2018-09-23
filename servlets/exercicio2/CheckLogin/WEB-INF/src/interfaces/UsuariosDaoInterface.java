package interfaces;

import models.Usuario;

public interface UsuariosDaoInterface {
    public Usuario search (String usuario, String password);
    public void create (Usuario usuario);
}