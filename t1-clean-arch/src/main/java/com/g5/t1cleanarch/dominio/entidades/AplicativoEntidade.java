package com.g5.t1cleanarch.dominio.entidades;

public class AplicativoEntidade{
    private long codigo;
    private String nome;
    private double custoMensal;

    public AplicativoEntidade(long codigo, String nome, double custoMensal) {
        this.codigo = codigo;
        this.nome = nome;
        this.custoMensal = custoMensal;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getCustoMensal() {
        return custoMensal;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCustoMensal(double custoMensal) {
        this.custoMensal = custoMensal;
    }

    @Override
    public String toString() {
        return "Aplicativo [codigo=" + codigo + ", nome=" + nome + ", custoMensal=" + custoMensal + "]";
    }
}