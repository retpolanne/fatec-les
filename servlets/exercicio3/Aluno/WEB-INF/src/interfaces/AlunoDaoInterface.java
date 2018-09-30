package interfaces;

import java.util.List;
import models.Aluno;
import exceptions.GenericDAOException;

public interface AlunoDaoInterface {
    public Aluno search (long id) throws GenericDAOException;
    public List<Aluno> showAll () throws GenericDAOException;
    public void create (Aluno aluno) throws GenericDAOException;
    public void update (Aluno aluno) throws GenericDAOException;
    public void delete (long id) throws GenericDAOException;
}