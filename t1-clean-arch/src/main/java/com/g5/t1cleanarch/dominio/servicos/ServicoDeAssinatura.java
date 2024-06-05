package com.g5.t1cleanarch.dominio.servicos;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.g5.t1cleanarch.dominio.entidades.AplicativoEntidade;
import com.g5.t1cleanarch.dominio.entidades.ClienteEntidade;
import com.g5.t1cleanarch.dominio.enums.Status;
import com.g5.t1cleanarch.dominio.entidades.AssinaturaEntidade;
import com.g5.t1cleanarch.dominio.repositorios.IAssinaturaRepositorio;

@Service
public class ServicoDeAssinatura {
    private IAssinaturaRepositorio assinaturaRepositorio;

    public ServicoDeAssinatura(IAssinaturaRepositorio assinaturaRepositorio) {
        this.assinaturaRepositorio = assinaturaRepositorio;
    }

    public AssinaturaEntidade criaAssinatura(ClienteEntidade cliente, AplicativoEntidade aplicativo) {
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataExpiracao = dataAtual.plusDays(7); // novas assinaturas ganham 7 dias gratis, conforme regras adicionais
        return this.assinaturaRepositorio.cadastra(cliente, aplicativo, dataAtual, dataExpiracao);
    }

    public List<AssinaturaEntidade> listarAssinaturasPorTipo(String tipo) {
        return switch(tipo.toUpperCase()) {
            case "TODAS" -> listaAssinaturas();
            case "ATIVAS" -> listaAssinaturasAtivas();
            case "CANCELADAS" -> listaAssinaturasCanceladas();
            default -> new LinkedList<AssinaturaEntidade>();
        };
    }

    public List<AssinaturaEntidade> listaAssinaturas() {
        return assinaturaRepositorio.todas();
    }

    public List<AssinaturaEntidade> listaAssinaturasAtivas() {
        return assinaturaRepositorio.listaAssinaturasAtivas();
    }

    public List<AssinaturaEntidade> listaAssinaturasCanceladas() {
        return assinaturaRepositorio.listaAssinaturasCanceladas();
    }

    public AssinaturaEntidade getAssinaturaById(long codigo) {
        return assinaturaRepositorio.getAssinaturaById(codigo);
    }

    public Status verificaStatusAssinatura(AssinaturaEntidade assinatura) {
        return verificarAssinaturaValida(assinatura) ? Status.ATIVA : Status.CANCELADA;
    }

    public boolean verificarAssinaturaValida(AssinaturaEntidade assinatura) {
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataExpiracao = assinatura.getFimVigencia();

        return dataAtual.isBefore(dataExpiracao);
    }

    public boolean verificaValorAssinaturaValida(AssinaturaEntidade assinatura, double valorPago) {
        return assinatura.getAplicativo().getCustoMensal() == valorPago;
    }

    public List<AssinaturaEntidade> getAssinaturasCliente(long codigo) {
        return assinaturaRepositorio.getAssinaturasCliente(codigo);
    }

    public List<AssinaturaEntidade> getAssinaturasAplicativo(long codigo) {
        return this.assinaturaRepositorio.getAssinaturasAplicativo(codigo);
    }

    public AssinaturaEntidade atualizaAssinatura(AssinaturaEntidade assinatura) {
        return assinaturaRepositorio.atualizaAssinatura(assinatura);
    }
}
