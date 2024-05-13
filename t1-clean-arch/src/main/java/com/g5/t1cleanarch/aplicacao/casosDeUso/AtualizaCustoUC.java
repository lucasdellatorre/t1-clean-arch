package com.g5.t1cleanarch.aplicacao.casosDeUso;

import org.springframework.stereotype.Component;

import com.g5.t1cleanarch.aplicacao.dtos.AplicativoDTO;
import com.g5.t1cleanarch.aplicacao.dtos.AtualizaCustoMensalRequisicaoDTO;
import com.g5.t1cleanarch.dominio.servicos.ServicoDeAplicativos;

@Component
public class AtualizaCustoUC {
    private ServicoDeAplicativos servicoDeAplicativos;

    public AtualizaCustoUC(ServicoDeAplicativos servicoDeAplicativos) {
        this.servicoDeAplicativos = servicoDeAplicativos;
    }

    public AplicativoDTO run(long codigo, AtualizaCustoMensalRequisicaoDTO atualizaCustoMensalRequisicaoDTO) {
        return AplicativoDTO.fromEntity(this.servicoDeAplicativos.atualizaCustoMensal(codigo, atualizaCustoMensalRequisicaoDTO.getCustoMensal()));
    }
}
