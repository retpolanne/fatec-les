package models;

public class Usuario {
    private String usuario;
    private String nome;
    private String email;
    private String telefone;
    private String passwordHash;
    private String perfil;

    public String getUsuario () {
        return this.usuario;
    }

    public void setUsuario (String usuario) {
        this.usuario = usuario;
    }

    public String getNome () {
        return this.nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getEmail () {
        return this.email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getTelefone () {
        return this.telefone;
    }

    public void setTelefone (String telefone) {
        this.telefone = telefone;
    }

    public String getPassword () {
        return this.passwordHash;
    }

    public void setPassword (String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPerfil () {
        return this.perfil;
    }

    public void setPerfil (String perfil) {
        this.perfil = perfil;
    }
}