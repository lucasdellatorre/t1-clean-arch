package com.g5.t1cleanarch.aplicacao.dtos;

public class AtualizaCustoMensalRequisicaoDTO {
    private double custo;
    private double id;

    public AtualizaCustoMensalRequisicaoDTO(double custo, int id) 
    {
        this.custo = custo;
        this.id = id;
    }

    public double getCustoMensal() {
        return custo;
    }
}