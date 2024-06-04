package com.g5.t1cleanarch.adaptadores.repositorios.h2;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.g5.t1cleanarch.adaptadores.repositorios.AplicativoJPA_ItfRep;
import com.g5.t1cleanarch.adaptadores.repositorios.entidades.Aplicativo;
import com.g5.t1cleanarch.dominio.entidades.AplicativoEntidade;
import com.g5.t1cleanarch.dominio.repositorios.IAplicativoRepositorio;

@Repository
@Primary
public class AplicativoRepositiorioJPA implements IAplicativoRepositorio {
    private AplicativoJPA_ItfRep aplicativoRepositorio;

    public AplicativoRepositiorioJPA(AplicativoJPA_ItfRep aplicativoRepositorio) {
        this.aplicativoRepositorio = aplicativoRepositorio;
    }

    @Override
    public List<AplicativoEntidade> todos() {
        List<Aplicativo> aplicativos =  this.aplicativoRepositorio.findAll();

        if (aplicativos.size() == 0) {
            return new LinkedList<AplicativoEntidade>();
        }
        return aplicativos.stream()
            .map(app -> Aplicativo.toAplicativoEntidade(app))
            .toList();
    }

    @Override
    public AplicativoEntidade getAplicativoPorCodigo(long codigo) {
        Aplicativo aplicativo = this.aplicativoRepositorio.findById(codigo);
        return aplicativo == null ? null : Aplicativo.toAplicativoEntidade(aplicativo);
    }

    @Override
    public AplicativoEntidade atualizaCustoMensal(long codigo, double custoMensal) {
        Aplicativo app = this.aplicativoRepositorio.findById(codigo);

        if (app == null) {
            throw new IllegalArgumentException("Aplicativo inexistente");
        }

        app.setCustoMensal(custoMensal);

        this.aplicativoRepositorio.save(app);

        return Aplicativo.toAplicativoEntidade(app);
    }
}
