package com.g5.t1cleanarch.dominio.servicos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.g5.t1cleanarch.dominio.entidades.ClienteEntidade;
import com.g5.t1cleanarch.dominio.repositorios.IClienteRepositorio;

@Service
public class ServicoDeClientes {
    private IClienteRepositorio clienteRepo;

    public ServicoDeClientes(IClienteRepositorio clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    public List<ClienteEntidade> listaClientes() {
        return clienteRepo.todos();
    }

    public ClienteEntidade getClientePorCodigo(long codigo) {
        return clienteRepo.getClientePorCodigo(codigo);
    }
}
