package com.g5.t1cleanarch.aplicacao.dtos;

import java.time.LocalDate;

import com.g5.t1cleanarch.dominio.entidades.AplicativoEntidade;
import com.g5.t1cleanarch.dominio.entidades.AssinaturaEntidade;
import com.g5.t1cleanarch.dominio.entidades.ClienteEntidade;

public class AssinaturaDTO {
    private long codigo;
    private AplicativoEntidade aplicativo;
    private ClienteEntidade cliente;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;

    public AssinaturaDTO(long codigo, AplicativoEntidade aplicativo, ClienteEntidade cliente, LocalDate inicioVigencia, LocalDate fimVigencia) {
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

    public LocalDate getInicioVigencia() {
        return inicioVigencia;
    }

    public LocalDate getFimVigencia() {
        return fimVigencia;
    }

    public static AssinaturaDTO fromEntity(AssinaturaEntidade assinatura) {
        return new AssinaturaDTO(assinatura.getCodigo(), assinatura.getAplicativo(), assinatura.getCliente(), assinatura.getInicioVigencia(), assinatura.getFimVigencia());
    }
}
