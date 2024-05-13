package com.g5.t1cleanarch.dominio.repositorios;

import java.util.List;

import com.g5.t1cleanarch.dominio.entidades.AplicativoEntidade;

public interface IAplicativoRepositorio {
    List<AplicativoEntidade> todos();
    AplicativoEntidade getAplicativoPorCodigo(long codigo);
    AplicativoEntidade atualizaCustoMensal(long codigo, double custoMensal);
}
