package models;

public class Dificuldade {
    private String dificuldade;

    public void setDificuldade (String dificuldade) {
        this.dificuldade = dificuldade;
    }

    @Override
    public String toString () {
        return this.dificuldade;
    }
}