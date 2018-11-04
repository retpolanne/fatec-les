package interfaces;

import exceptions.GenericDAOException;
import models.Noticias;

import java.util.List;

public interface NoticiasDaoInterface {
    public List<Noticias> showAll () throws GenericDAOException;
}