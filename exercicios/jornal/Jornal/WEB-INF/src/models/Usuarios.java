package models;

public class Usuarios {
    private String nome;

    public Usuarios () {
        
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getNome () {
        return this.nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}