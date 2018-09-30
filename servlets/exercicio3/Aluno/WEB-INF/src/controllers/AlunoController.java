package controllers;

import java.util.List;
import models.Aluno;
import dao.AlunoDao;
import interfaces.AlunoDaoInterface;
import exceptions.GenericDAOException;

public class AlunoController {

    private AlunoDaoInterface alunoDao = new AlunoDao();
    
    public List<Aluno> showAll () throws GenericDAOException {
        return alunoDao.showAll();
    }

    public void createAluno (Aluno aluno) throws GenericDAOException {
        alunoDao.create(aluno);
    }

    public void updateAluno (Aluno aluno) throws GenericDAOException {
        alunoDao.update(aluno);
    }

    public Aluno search (long id) throws GenericDAOException {
        return alunoDao.search(id);
    }

    public void delete (long id) throws GenericDAOException {
        alunoDao.delete(id);
    }
}