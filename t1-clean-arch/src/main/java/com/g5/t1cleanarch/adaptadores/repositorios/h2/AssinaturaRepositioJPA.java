package com.g5.t1cleanarch.adaptadores.repositorios.h2;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.g5.t1cleanarch.adaptadores.repositorios.AssinaturaJPA_ItfRep;
import com.g5.t1cleanarch.adaptadores.repositorios.entidades.Aplicativo;
import com.g5.t1cleanarch.adaptadores.repositorios.entidades.Assinatura;
import com.g5.t1cleanarch.adaptadores.repositorios.entidades.Cliente;
import com.g5.t1cleanarch.dominio.entidades.AplicativoEntidade;
import com.g5.t1cleanarch.dominio.entidades.AssinaturaEntidade;
import com.g5.t1cleanarch.dominio.entidades.ClienteEntidade;
import com.g5.t1cleanarch.dominio.repositorios.IAssinaturaRepositorio;

@Repository
@Primary
public class AssinaturaRepositioJPA implements IAssinaturaRepositorio {
    private AssinaturaJPA_ItfRep assinaturaRepositorio;

    public AssinaturaRepositioJPA(AssinaturaJPA_ItfRep assinaturaRepositorio) {
        this.assinaturaRepositorio = assinaturaRepositorio;
    }

    @Override
    public AssinaturaEntidade cadastra(ClienteEntidade cliente, AplicativoEntidade aplicativo, LocalDate dataAtual, LocalDate dataExpiracao) {
        Assinatura assinatura = new Assinatura(Aplicativo.fromAplicativoEntidade(aplicativo), Cliente.fromClienteEntidade(cliente), dataAtual, dataExpiracao);

        this.assinaturaRepositorio.save(assinatura);

        return Assinatura.toAssinaturaEntidade(assinatura);
    }

    @Override
    public List<AssinaturaEntidade> getAssinaturasCliente(long codigo) {
        List<Assinatura> assinaturas = assinaturaRepositorio.findByClienteCodigo(codigo);

        if (assinaturas.size() == 0) {
            return new LinkedList<AssinaturaEntidade>();
        }

        return assinaturas.stream()
            .map(assinatura -> Assinatura.toAssinaturaEntidade(assinatura))
            .toList();
    }

    @Override
    public List<AssinaturaEntidade> getAssinaturasAplicativo(long codigo) {
        List<Assinatura> assinaturas = assinaturaRepositorio.findByAplicativoCodigo(codigo);

        if (assinaturas.size() == 0) {
            return new LinkedList<AssinaturaEntidade>();
        }

        return assinaturas.stream()
            .map(assinatura -> Assinatura.toAssinaturaEntidade(assinatura))
            .toList();
    }

    public List<AssinaturaEntidade> todas() {
        List<Assinatura> assinaturas = assinaturaRepositorio.findAll();

        if (assinaturas.size() == 0) {
            return new LinkedList<AssinaturaEntidade>();
        }

        return assinaturas.stream()
            .map(assinatura -> Assinatura.toAssinaturaEntidade(assinatura))
            .toList();
    }

    @Override
    public AssinaturaEntidade getAssinaturaById(long codigo) {
        Assinatura assinatura = assinaturaRepositorio.findById(codigo);
        return assinatura == null ? null : Assinatura.toAssinaturaEntidade(assinatura);
    }

    @Override
    public AssinaturaEntidade atualizaAssinatura(AssinaturaEntidade assinaturaEntidade) {
        Assinatura assinatura = assinaturaRepositorio.save(Assinatura.fromAssinaturaEntidade(assinaturaEntidade));
        return Assinatura.toAssinaturaEntidade(assinatura);
    }

    @Override
    public List<AssinaturaEntidade> listaAssinaturasAtivas() {
        List<Assinatura> assinaturas = assinaturaRepositorio.findAllAssinaturasAtivas();

        return assinaturas.stream()
            .map(assinatura -> Assinatura.toAssinaturaEntidade(assinatura))
            .toList();
    }

    @Override
    public List<AssinaturaEntidade> listaAssinaturasCanceladas() {
        List<Assinatura> assinaturas = assinaturaRepositorio.findAllAssinaturasCanceladas();

        return assinaturas.stream()
            .map(assinatura -> Assinatura.toAssinaturaEntidade(assinatura))
            .toList();
    }
}
