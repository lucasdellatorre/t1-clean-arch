package com.g5.t1cleanarch.adaptadores.repositorios;

import com.g5.t1cleanarch.dominio.entidades.AplicativoEntidade;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Aplicativo {
    @Id
    private long codigo;
    private String nome;
    private double custoMensal;

    protected Aplicativo() {}

    public Aplicativo(long codigo, String nome, double custoMensal) {
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

    public static Aplicativo fromAplicativoEntidade(AplicativoEntidade appEntidade) {
        return new Aplicativo(appEntidade.getCodigo(), appEntidade.getNome(), appEntidade.getCustoMensal());

    }

    public static AplicativoEntidade toAplicativoEntidade(Aplicativo app) {
        return new AplicativoEntidade(app.getCodigo(), app.getNome(), app.getCustoMensal());

    }
}