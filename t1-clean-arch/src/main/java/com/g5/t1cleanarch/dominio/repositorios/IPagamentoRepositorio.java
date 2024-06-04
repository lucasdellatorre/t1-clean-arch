package com.g5.t1cleanarch.dominio.repositorios;

import java.time.LocalDate;

import com.g5.t1cleanarch.dominio.entidades.AssinaturaEntidade;
import com.g5.t1cleanarch.dominio.entidades.PagamentoEntidade;

public interface IPagamentoRepositorio {
    PagamentoEntidade registraPagamento(AssinaturaEntidade assinatura, double valorPago, LocalDate dataPagamento);
}
