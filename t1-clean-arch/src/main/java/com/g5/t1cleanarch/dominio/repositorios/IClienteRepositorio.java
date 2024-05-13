package com.g5.t1cleanarch.dominio.repositorios;

import java.util.List;

import com.g5.t1cleanarch.dominio.entidades.ClienteEntidade;

public interface IClienteRepositorio {
    List<ClienteEntidade> todos();
    ClienteEntidade getClientePorCodigo(long codigo);
}
