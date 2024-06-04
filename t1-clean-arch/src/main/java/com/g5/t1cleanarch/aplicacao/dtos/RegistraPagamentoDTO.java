package com.g5.t1cleanarch.aplicacao.dtos;

import java.time.LocalDate;

import com.g5.t1cleanarch.dominio.enums.StatusPagamento;

public class RegistraPagamentoDTO {
    private StatusPagamento status;
    private LocalDate dataPagamento;
    private double valorEstornado;

    public RegistraPagamentoDTO(StatusPagamento status, LocalDate dataPagamento, double valorEstornado) {
        this.status = status;
        this.dataPagamento = dataPagamento;
        this.valorEstornado = valorEstornado;
    }

    public StatusPagamento getStatusPagamento() {
        return status;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public double getValorEstornado() {
        return valorEstornado;
    }
}

