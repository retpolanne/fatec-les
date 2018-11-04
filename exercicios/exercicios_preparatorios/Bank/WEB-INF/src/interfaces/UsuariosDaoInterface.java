package interfaces;

import exceptions.GenericDAOException;
import models.Usuarios;

import java.util.List;

public interface UsuariosDaoInterface {
    public List<Usuarios> showAll () throws GenericDAOException;
}