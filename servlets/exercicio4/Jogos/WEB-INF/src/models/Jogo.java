package models;
import models.Dificuldade;

public class Jogo {
    private String nome;
    private String dificuldade;

    public String getNome () {
        return this.nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getDificuldade () {
        return this.dificuldade;
    }

    public void setDificuldade (String dificuldade) {
        Dificuldade dif = new Dificuldade();
        dif.setDificuldade(dificuldade);
        this.dificuldade = dificuldade.toString();
    }
}