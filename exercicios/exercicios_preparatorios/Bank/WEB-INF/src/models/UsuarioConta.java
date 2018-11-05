package models;

public class UsuarioConta {
    private Usuario usuario;
    private Conta conta;
    public UsuarioConta () {
    }

    public void setIdConta (Conta conta) {
        this.conta = conta;
    }

    public long getIdConta () {
        return this.conta.getId();
    }

    public void setIdUsuario (Usuario usuario) {
        this.usuario = usuario;
    }

    public long getIdUsuario () {
        return this.usuario.getId();
    }
}