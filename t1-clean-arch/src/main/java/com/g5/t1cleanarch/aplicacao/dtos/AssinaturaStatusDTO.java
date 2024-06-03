package com.g5.t1cleanarch.aplicacao.dtos;

import java.time.LocalDate;

import com.g5.t1cleanarch.dominio.entidades.AplicativoEntidade;
import com.g5.t1cleanarch.dominio.entidades.AssinaturaEntidade;
import com.g5.t1cleanarch.dominio.entidades.ClienteEntidade;
import com.g5.t1cleanarch.dominio.enums.Status;

public class AssinaturaStatusDTO {
    private long codigo;
    private long codigoAplicativo;
    private long codigoCliente;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;
    private Status status;

    public AssinaturaStatusDTO(long codigo, AplicativoEntidade aplicativo, ClienteEntidade cliente, LocalDate inicioVigencia, LocalDate fimVigencia, Status status) {
        this.codigo = codigo;
        this.codigoAplicativo = aplicativo.getCodigo();
        this.codigoCliente = cliente.getCodigo();
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.status = status;
    }

    public long getCodigo() {
        return codigo;
    }

    public long getCodigoAplicativo() {
        return codigoAplicativo;
    }

    public long getCodigoCliente() {
        return codigoCliente;
    }

    public LocalDate getInicioVigencia() {
        return inicioVigencia;
    }

    public LocalDate getFimVigencia() {
        return fimVigencia;
    }

    public Status getStatus() {
        return status;
    }

    public static AssinaturaStatusDTO fromEntity(AssinaturaEntidade assinatura, Status status) {
        return new AssinaturaStatusDTO(assinatura.getCodigo(), assinatura.getAplicativo(), assinatura.getCliente(), assinatura.getInicioVigencia(), assinatura.getFimVigencia(), status);
    }
}