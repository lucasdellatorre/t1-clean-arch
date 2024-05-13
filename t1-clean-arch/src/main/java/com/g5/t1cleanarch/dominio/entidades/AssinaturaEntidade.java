package com.g5.t1cleanarch.dominio.entidades;

import java.time.LocalDate;

public class AssinaturaEntidade{
    private long codigo;
    private AplicativoEntidade aplicativo;
    private ClienteEntidade cliente;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;

    public AssinaturaEntidade(long codigo, AplicativoEntidade aplicativo, ClienteEntidade cliente, LocalDate dataAtual, LocalDate dataAtualMais30Dias) {
        this.codigo = codigo;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.inicioVigencia = dataAtual;
        this.fimVigencia = dataAtualMais30Dias;
    }

    public long getCodigo() {
        return codigo;
    }

    public AplicativoEntidade getAplicativo() {
        return aplicativo;
    }

    public ClienteEntidade getCliente() {
        return cliente;
    }

    public LocalDate getInicioVigencia() {
        return inicioVigencia;
    }

    public LocalDate getFimVigencia() {
        return fimVigencia;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setAplicativo(AplicativoEntidade aplicativo) {
        this.aplicativo = aplicativo;
    }

    public void setCliente(ClienteEntidade cliente) {
        this.cliente = cliente;
    }

    public void setInicioVigencia(LocalDate inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public void setFimVigencia(LocalDate fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    @Override
    public String toString() {
        return "Assinatura [codigo=" + codigo + ", aplicativo=" + aplicativo + ", cliente=" + cliente + ", inicioVigencia=" + inicioVigencia +  ", fimVigencia=" + fimVigencia + "]";
    }
}