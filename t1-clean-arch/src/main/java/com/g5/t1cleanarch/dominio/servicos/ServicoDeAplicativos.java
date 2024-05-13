package com.g5.t1cleanarch.dominio.servicos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.g5.t1cleanarch.dominio.entidades.AplicativoEntidade;
import com.g5.t1cleanarch.dominio.repositorios.IAplicativoRepositorio;

@Service
public class ServicoDeAplicativos {
    private IAplicativoRepositorio aplicativoRepositorio;

    public ServicoDeAplicativos(IAplicativoRepositorio aplicativoRepositorio) {
        this.aplicativoRepositorio = aplicativoRepositorio;
    }

    public List<AplicativoEntidade> todos() {
        return this.aplicativoRepositorio.todos();
    }

    public AplicativoEntidade getAplicativoPorCodigo(long codigo) {
        return this.aplicativoRepositorio.getAplicativoPorCodigo(codigo);
    }

    public AplicativoEntidade atualizaCustoMensal(long codigo, double custoMensal) {
        return this.aplicativoRepositorio.atualizaCustoMensal(codigo, custoMensal);
    }
}
