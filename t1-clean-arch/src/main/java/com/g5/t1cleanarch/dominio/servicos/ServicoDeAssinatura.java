package com.g5.t1cleanarch.dominio.servicos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.g5.t1cleanarch.dominio.entidades.AplicativoEntidade;
import com.g5.t1cleanarch.dominio.entidades.ClienteEntidade;
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
        return this.assinaturaRepositorio.listarAssinaturasPorTipo(tipo);
    }

    public AssinaturaEntidade getAssinaturaById(long codigo) {
        return this.assinaturaRepositorio.getAssinaturaById(codigo);
    }

    public boolean verificarAssinaturaInvalida(AssinaturaEntidade assinatura) {
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataExpiracao = assinatura.getFimVigencia();

        return dataExpiracao.isEqual(dataAtual) || dataExpiracao.isAfter(dataAtual);
    }

    public boolean verificaValorAssinaturaValida(AssinaturaEntidade assinatura, double valorPago) {
        return assinatura.getAplicativo().getCustoMensal() == valorPago;
    }

    public List<AssinaturaEntidade> getAssinaturasCliente(long codigo) {
        return this.assinaturaRepositorio.getAssinaturasCliente(codigo);
    }

    public AssinaturaEntidade atualizaAssinatura(AssinaturaEntidade assinatura) {
        return this.assinaturaRepositorio.atualizaAssinatura(assinatura);
    }
}
