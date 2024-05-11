package com.g5.t1cleanarch.dominio.repositorios.IClienteRepositorio;

import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository implements IClienteRepositorio {
    public List<ProdutoModel> todos(){
        return produtos;
    }
}