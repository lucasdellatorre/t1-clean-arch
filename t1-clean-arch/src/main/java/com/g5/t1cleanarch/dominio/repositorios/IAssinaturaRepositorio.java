package com.g5.t1cleanarch.dominio.repositorios;

import java.time.LocalDate;
import java.util.List;

import com.g5.t1cleanarch.dominio.entidades.AplicativoEntidade;
import com.g5.t1cleanarch.dominio.entidades.AssinaturaEntidade;
import com.g5.t1cleanarch.dominio.entidades.ClienteEntidade;

public interface IAssinaturaRepositorio {
    AssinaturaEntidade cadastra(ClienteEntidade cliente, AplicativoEntidade aplicativo, LocalDate dataAtual, LocalDate dataExpiracao);
    boolean verificarAssinaturaInvalida(long codigo, LocalDate dataAtual);
    List<AssinaturaEntidade> getAssinaturasCliente(long codigo);
    List<AssinaturaEntidade> getAssinaturasAplicativo(long codigo);
}
