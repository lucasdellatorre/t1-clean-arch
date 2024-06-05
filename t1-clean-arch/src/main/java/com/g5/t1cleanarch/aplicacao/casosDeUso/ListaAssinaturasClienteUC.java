package com.g5.t1cleanarch.aplicacao.casosDeUso;

import java.util.List;

import org.springframework.stereotype.Component;

import com.g5.t1cleanarch.aplicacao.dtos.AssinaturaStatusDTO;
import com.g5.t1cleanarch.dominio.entidades.AssinaturaEntidade;
import com.g5.t1cleanarch.dominio.servicos.ServicoDeAssinatura;

@Component
public class ListaAssinaturasClienteUC {
    private ServicoDeAssinatura servicoDeAssinatura;

    public ListaAssinaturasClienteUC(ServicoDeAssinatura servicoDeAssinatura) {
        this.servicoDeAssinatura = servicoDeAssinatura;
    }

    public List<AssinaturaStatusDTO> run(long codigo) {
        List<AssinaturaEntidade> assinaturas = servicoDeAssinatura.getAssinaturasCliente(codigo);

        return assinaturas.stream()
        .map(assinatura -> AssinaturaStatusDTO.fromEntity(assinatura, servicoDeAssinatura.verificaStatusAssinatura(assinatura)))
        .toList();
    }
}