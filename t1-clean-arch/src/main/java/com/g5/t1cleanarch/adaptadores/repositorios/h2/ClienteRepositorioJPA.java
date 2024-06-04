package com.g5.t1cleanarch.adaptadores.repositorios.h2;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.g5.t1cleanarch.adaptadores.repositorios.ClienteJPA_ItfRep;
import com.g5.t1cleanarch.adaptadores.repositorios.entidades.Cliente;
import com.g5.t1cleanarch.dominio.entidades.ClienteEntidade;
import com.g5.t1cleanarch.dominio.repositorios.IClienteRepositorio;

@Repository
@Primary
public class ClienteRepositorioJPA implements IClienteRepositorio {
    private ClienteJPA_ItfRep clienteRepositorio;

    public ClienteRepositorioJPA (ClienteJPA_ItfRep clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    @Override
    public List<ClienteEntidade> todos() {
        List<Cliente> clientes = clienteRepositorio.findAll();

        if (clientes.size() == 0) {
            return new LinkedList<ClienteEntidade>();
        }

        return clientes.stream()
            .map(cliente -> Cliente.toClienteEntidade(cliente))
            .toList();
    }

    @Override
    public ClienteEntidade getClientePorCodigo(long codigo) {
        Cliente cliente = clienteRepositorio.findById(codigo);
        return cliente == null ? null : Cliente.toClienteEntidade(cliente);
    }
}
