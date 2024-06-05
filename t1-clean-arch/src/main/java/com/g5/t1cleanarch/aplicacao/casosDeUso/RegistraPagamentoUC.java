package com.g5.t1cleanarch.aplicacao.casosDeUso;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;

import com.g5.t1cleanarch.aplicacao.dtos.RegistraPagamentoDTO;
import com.g5.t1cleanarch.aplicacao.dtos.RegistraPagamentoRequisicaoDTO;
import com.g5.t1cleanarch.dominio.entidades.AssinaturaEntidade;
import com.g5.t1cleanarch.dominio.enums.StatusPagamento;
import com.g5.t1cleanarch.dominio.servicos.ServicoDeAssinatura;
import com.g5.t1cleanarch.dominio.servicos.ServicoDePagamentos;

@Component
public class RegistraPagamentoUC {
    private ServicoDePagamentos servicoDePagamentos;
    private ServicoDeAssinatura servicoDeAssinatura;

    public RegistraPagamentoUC(ServicoDePagamentos servicoDePagamentos, ServicoDeAssinatura servicoDeAssinatura) {
        this.servicoDePagamentos = servicoDePagamentos;
        this.servicoDeAssinatura = servicoDeAssinatura;
    }

    public RegistraPagamentoDTO run(RegistraPagamentoRequisicaoDTO registraPagamentoDTO) {
        long codass = registraPagamentoDTO.getCodass();
        LocalDate dataPagamento = registraPagamentoDTO.getDataPagamento();
        double valorPago = registraPagamentoDTO.getValorPago();
        AssinaturaEntidade assinatura = servicoDeAssinatura.getAssinaturaById(codass);

        boolean pagamentoValido = servicoDeAssinatura.verificaValorAssinaturaValida(assinatura, valorPago);

        if (!pagamentoValido) {
            // não estamos cobrindo o caso de promoções inexistentes ou não aplicáveis
            return new RegistraPagamentoDTO(StatusPagamento.VALOR_INCORRETO, assinatura.getFimVigencia(), valorPago);
        }

        LocalDate novaDataFimVigencia;
        boolean assinaturaAtiva = servicoDeAssinatura.verificarAssinaturaValida(assinatura);

        if (assinaturaAtiva) {
            long diferencaEntreDataPagamentoEFimVigenciaEmDias = ChronoUnit.DAYS.between(dataPagamento, assinatura.getFimVigencia());
            novaDataFimVigencia = dataPagamento.plusDays(30 + diferencaEntreDataPagamentoEFimVigenciaEmDias);
        } else {
            novaDataFimVigencia = dataPagamento.plusDays(30);
        }

        assinatura.setFimVigencia(novaDataFimVigencia);

        servicoDeAssinatura.atualizaAssinatura(assinatura);

        servicoDePagamentos.registraPagamento(assinatura, valorPago, dataPagamento);

        return new RegistraPagamentoDTO(StatusPagamento.PAGAMENTO_OK, novaDataFimVigencia, 0);
    }
}
