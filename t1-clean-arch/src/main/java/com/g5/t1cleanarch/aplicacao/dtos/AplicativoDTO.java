package com.g5.t1cleanarch.aplicacao.dtos;

import com.g5.t1cleanarch.dominio.entidades.AplicativoEntidade;

public class AplicativoDTO {
    private long codigo;
    private String nome;
    private double custoMensal;

    public AplicativoDTO(long codigo, String nome, double custoMensal) {
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

    public static AplicativoDTO fromEntity(AplicativoEntidade aplicativo) {
        return new AplicativoDTO(aplicativo.getCodigo(), aplicativo.getNome(), aplicativo.getCustoMensal());
    }
}
