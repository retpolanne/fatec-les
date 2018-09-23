package interfaces;

import model.Usuario;

public interface UsuariosDaoInterface {
    public Usuario search (String usuario, String password);
}