package controllers;

import java.util.ArrayList;
import java.util.List;
import models.Jogo;
import dao.JogosDao;
import interfaces.JogosDaoInterface;
import models.Dificuldade;
import dao.DificuldadesDao;
import interfaces.DificuldadesDaoInterface;
import exceptions.GenericDAOException;

public class JogosController {

    private JogosDaoInterface jogosDao = new JogosDao();
    private DificuldadesDaoInterface dificuldadesDao = new DificuldadesDao();

    public List<String> showDificuldades () throws GenericDAOException {
        List<Dificuldade> difs = dificuldadesDao.showAll();
        List<String> difStrings = new ArrayList<String>();

        for (Dificuldade dif : difs) {
            difStrings.add(dif.toString());
        }
        return difStrings;
    }
    
    public void createJogo (Jogo jogo) throws GenericDAOException {
        jogosDao.create(jogo);
    }

    public Jogo searchJogo (String nome) throws GenericDAOException {
        return jogosDao.search(nome);
    }
}