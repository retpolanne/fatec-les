package interfaces;

import java.util.List;
import models.Dificuldade;
import exceptions.GenericDAOException;

public interface DificuldadesDaoInterface {
    public List<Dificuldade> showAll () throws GenericDAOException;
}