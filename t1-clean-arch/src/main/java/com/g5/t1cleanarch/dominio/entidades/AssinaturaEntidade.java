package com.g5.t1cleanarch.domain.entidades;

import java.util.Date;

public class AssinaturaEntidade{
    private long codigo;
    private AplicativoEntidade aplicativo;
    private ClienteEntidade cliente;
    private Date inicioVigencia;
    private Date fimVigencia;

    public AssinaturaEntidade(long codigo, AplicativoEntidade aplicativo, ClienteEntidade cliente, Date inicioVigencia, Date fimVigencia) {
        this.codigo = codigo;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
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

    public Date getInicioVigencia() {
        return inicioVigencia;
    }

    public Date getFimVigencia() {
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

    public void setInicioVigencia(Date inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public void setFimVigencia(Date fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    @Override
    public String toString() {
        return "Assinatura [codigo=" + codigo + ", aplicativo=" + aplicativo + ", cliente=" + cliente + ", inicioVigencia=" + inicioVigencia +  ", fimVigencia=" + fimVigencia + "]";
    }
}