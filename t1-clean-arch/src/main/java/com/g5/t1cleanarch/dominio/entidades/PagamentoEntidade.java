package com.g5.t1cleanarch.dominio.entidades;

import java.time.LocalDate;

public class PagamentoEntidade{
    private long codigo;
    private AssinaturaEntidade assinatura;
    private double valorPago;
    private LocalDate dataPagamento;
    private String promocao;

    public PagamentoEntidade(long codigo, AssinaturaEntidade assinatura, double valorPago, LocalDate dataPagamento, String promocao) {
        this.codigo = codigo;
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public long getCodigo() {
        return codigo;
    }

    public AssinaturaEntidade getAssinatura() {
        return assinatura;
    }

    public double getValorPago() {
        return valorPago;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public String getPromocao() {
        return promocao;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setAssinatura(AssinaturaEntidade assinatura) {
        this.assinatura = assinatura;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public void setPromocao(String promocao) {
        this.promocao = promocao;
    }

    @Override
    public String toString() {
        return "Pagamento [codigo=" + codigo + ", assinatura=" + assinatura + ", valorPago=" + valorPago + ", dataPagamento=" + dataPagamento +  ", promocao=" + promocao + "]";
    }
}