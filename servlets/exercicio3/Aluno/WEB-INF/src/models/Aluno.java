package models;

public class Aluno {
    private long id;
    private String ra;
    private String nome;
    private int idade;
    private String sexo;

    public long getId () {
        return this.id;
    }

    public void setId (long id) {
        this.id = id;
    }

    public String getRa () {
        return this.ra;
    }

    public void setRa (String ra) {
        this.ra = ra;
    }

    public String getNome () {
        return this.nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public int getIdade () {
        return this.idade;
    }

    public void setIdade (int idade) {
        this.idade = idade;
    }

    public String getSexo () {
        return this.sexo;
    }

    public void setSexo (String sexo) {
        this.sexo = sexo;
    }
}