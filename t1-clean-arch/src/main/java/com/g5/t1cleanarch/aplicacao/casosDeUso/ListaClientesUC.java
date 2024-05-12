package com.g5.t1cleanarch.aplicacao.casosDeUso;

import java.util.List;

import org.springframework.stereotype.Component;

import com.g5.t1cleanarch.aplicacao.dtos.ClienteDTO;
import com.g5.t1cleanarch.dominio.servicos.ServicoDeClientes;

@Component
public class ListaClientesUC {
    private ServicoDeClientes servicoDeClientes;

    public ListaClientesUC(ServicoDeClientes servicoDeClientes) {
        this.servicoDeClientes = servicoDeClientes;
    }

    public List<ClienteDTO> run() {
        return servicoDeClientes.listaClientes().stream()
            .map(c -> ClienteDTO.fromEntity(c))
            .toList(); 
    }
}
