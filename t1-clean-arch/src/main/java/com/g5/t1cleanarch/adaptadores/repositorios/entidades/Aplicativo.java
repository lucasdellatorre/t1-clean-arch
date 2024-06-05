package com.g5.t1cleanarch.adaptadores.repositorios.entidades;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.g5.t1cleanarch.dominio.entidades.AplicativoEntidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Aplicativo {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
      name = "sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "aplicativo_sequence"),
        @Parameter(name = "initial_value", value = "6"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
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