package com.g5.t1cleanarch.aplicacao.dtos;

public class CriaAssinaturaRequisicaoDTO {
    private long codigoCliente;
    private long codigoAplicativo;

    public CriaAssinaturaRequisicaoDTO(long codigoCliente, long codigoAplicativo) {
        this.codigoCliente    = codigoCliente;
        this.codigoAplicativo = codigoAplicativo;
    }

    public long getCodigoCliente() {
        return codigoCliente;
    }

    public long getCodigoAplicativo() {
        return codigoAplicativo;
    }
}
