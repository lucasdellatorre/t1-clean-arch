package com.g5.t1cleanarch.dominio.servicos;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.g5.t1cleanarch.dominio.entidades.AssinaturaEntidade;
import com.g5.t1cleanarch.dominio.entidades.PagamentoEntidade;
import com.g5.t1cleanarch.dominio.repositorios.IPagamentoRepositorio;

@Service
public class ServicoDePagamentos {
    private IPagamentoRepositorio pagamentoRepositorio;

    public ServicoDePagamentos(IPagamentoRepositorio pagamentoRepositorio) {
        this.pagamentoRepositorio = pagamentoRepositorio;
    }

    public PagamentoEntidade registraPagamento(AssinaturaEntidade assinatura, double valorPago, LocalDate dataPagamento) {
       return pagamentoRepositorio.registraPagamento(assinatura, valorPago, dataPagamento);
    }
}
