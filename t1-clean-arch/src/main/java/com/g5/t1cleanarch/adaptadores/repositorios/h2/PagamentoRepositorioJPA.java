package com.g5.t1cleanarch.adaptadores.repositorios.h2;

import java.time.LocalDate;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.g5.t1cleanarch.adaptadores.repositorios.PagamentoJPA_ItfRep;
import com.g5.t1cleanarch.adaptadores.repositorios.entidades.Assinatura;
import com.g5.t1cleanarch.adaptadores.repositorios.entidades.Pagamento;
import com.g5.t1cleanarch.dominio.entidades.AssinaturaEntidade;
import com.g5.t1cleanarch.dominio.entidades.PagamentoEntidade;
import com.g5.t1cleanarch.dominio.repositorios.IPagamentoRepositorio;

@Repository
@Primary
public class PagamentoRepositorioJPA implements IPagamentoRepositorio {
    private PagamentoJPA_ItfRep pagamentoRepositorio;

    public PagamentoRepositorioJPA(PagamentoJPA_ItfRep pagamentoRepositorio) {
        this.pagamentoRepositorio = pagamentoRepositorio;
    }

    @Override
    public PagamentoEntidade registraPagamento(AssinaturaEntidade assinatura, double valorPago, LocalDate dataPagamento) {
        Pagamento pagamento = new Pagamento(Assinatura.fromAssinaturaEntidade(assinatura), valorPago, dataPagamento, null);

        pagamentoRepositorio.save(pagamento);

        return Pagamento.toPagamentoEntidade(pagamento);
    }
}
