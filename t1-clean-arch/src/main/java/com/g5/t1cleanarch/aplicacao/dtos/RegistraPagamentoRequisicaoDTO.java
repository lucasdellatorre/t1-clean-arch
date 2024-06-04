package com.g5.t1cleanarch.aplicacao.dtos;

import java.time.LocalDate;

public class RegistraPagamentoRequisicaoDTO {
    private long codass;
    private LocalDate dataPagamento;
    private double valorPago;

    public RegistraPagamentoRequisicaoDTO(long codass,double valorPago, LocalDate dataPagamento) {
        this.codass = codass;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
    }

    public long getCodass() {
        return codass;
    }

    public double getValorPago() {
        return valorPago;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }
}