package com.g5.t1cleanarch.aplicacao.dtos;

public class AtualizaCustoMensalRequisicaoDTO {
    private double custo;

    public AtualizaCustoMensalRequisicaoDTO(double custo, int id) 
    {
        this.custo = custo;
    }

    public double getCustoMensal() {
        return custo;
    }
}