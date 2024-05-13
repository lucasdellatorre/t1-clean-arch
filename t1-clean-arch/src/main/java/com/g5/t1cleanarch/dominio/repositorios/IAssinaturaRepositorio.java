package com.g5.t1cleanarch.dominio.repositorios;

import com.g5.t1cleanarch.dominio.entidades.AplicativoEntidade;
import com.g5.t1cleanarch.dominio.entidades.AssinaturaEntidade;
import com.g5.t1cleanarch.dominio.entidades.ClienteEntidade;

public interface IAssinaturaRepositorio {
    AssinaturaEntidade cadastra(ClienteEntidade cliente, AplicativoEntidade aplicativo);
}
