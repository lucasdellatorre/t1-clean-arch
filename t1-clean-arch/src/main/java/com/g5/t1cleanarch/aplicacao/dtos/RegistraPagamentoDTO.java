package com.g5.t1cleanarch.aplicacao.dtos;

import java.time.LocalDate;

import com.g5.t1cleanarch.dominio.enums.StatusPagamento;

public class RegistraPagamentoDTO {
    private StatusPagamento status;
    private LocalDate dataValidade;
    private double valorEstornado;

    public RegistraPagamentoDTO(StatusPagamento status, LocalDate dataValidade, double valorEstornado) {
        this.status = status;
        this.dataValidade = dataValidade;
        this.valorEstornado = valorEstornado;
    }

    public StatusPagamento getStatusPagamento() {
        return status;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public double getValorEstornado() {
        return valorEstornado;
    }
}

