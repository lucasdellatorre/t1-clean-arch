package com.g5.t1cleanarch.aplicacao.casosDeUso;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

import com.g5.t1cleanarch.aplicacao.dtos.AssinaturaStatusDTO;
import com.g5.t1cleanarch.dominio.entidades.AssinaturaEntidade;
import com.g5.t1cleanarch.dominio.servicos.ServicoDeAssinatura;

@Service
public class ListaAssinaturasTipoUC {
    private ServicoDeAssinatura servicoDeAssinatura;

    public ListaAssinaturasTipoUC(ServicoDeAssinatura servicoDeAssinatura) {
        this.servicoDeAssinatura = servicoDeAssinatura;
    }

    public List<AssinaturaStatusDTO> run(String tipo) {
        List<AssinaturaEntidade> assinaturas = switch(tipo.toUpperCase()) {
            case "TODAS" -> servicoDeAssinatura.listaAssinaturas();
            case "ATIVAS" -> servicoDeAssinatura.listaAssinaturasAtivas();
            case "CANCELADAS" -> servicoDeAssinatura.listaAssinaturasCanceladas();
            default -> new LinkedList<AssinaturaEntidade>();
        };

        return assinaturas.stream()
            .map(assinatura -> AssinaturaStatusDTO.fromEntity(assinatura, (servicoDeAssinatura.verificaStatusAssinatura(assinatura))))
            .toList();
    }
}
