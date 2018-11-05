package models;

import java.util.Date;

public class Lancamento {
    private long id;
    private Conta conta;
    private String tipo;
    private String descricao;
    private float saldoAnterior;
    private float saldoPosterior;
    private float valor;
    private Date dataLancamento;

    public Lancamento () {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdConta() {
        return this.conta.getId();
    }

    public void setIdConta(Conta conta) {
        this.conta = conta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(float saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public float getSaldoPosterior() {
        return saldoPosterior;
    }

    public void setSaldoPosterior(float saldoPosterior) {
        this.saldoPosterior = saldoPosterior;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}