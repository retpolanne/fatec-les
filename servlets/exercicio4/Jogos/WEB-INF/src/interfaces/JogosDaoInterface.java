package interfaces;

import java.util.List;
import models.Jogo;
import exceptions.GenericDAOException;

public interface JogosDaoInterface {
    public Jogo search (String nome) throws GenericDAOException;
    public void create (Jogo jogo) throws GenericDAOException;
}