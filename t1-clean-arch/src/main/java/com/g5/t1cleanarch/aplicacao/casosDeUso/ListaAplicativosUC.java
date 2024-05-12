package com.g5.t1cleanarch.aplicacao.casosDeUso;

import java.util.List;

import org.springframework.stereotype.Component;

import com.g5.t1cleanarch.aplicacao.dtos.AplicativoDTO;
import com.g5.t1cleanarch.dominio.servicos.ServicoDeAplicativos;

@Component
public class ListaAplicativosUC {
    private ServicoDeAplicativos servicoDeAplicativos;

    public ListaAplicativosUC(ServicoDeAplicativos servicoDeAplicativos) {
        this.servicoDeAplicativos = servicoDeAplicativos;
    }

    public List<AplicativoDTO> run() {
        return this.servicoDeAplicativos.todos().stream()
            .map(a -> AplicativoDTO.fromEntity(a))
            .toList();
    }
}
