package com.g5.t1cleanarch.adaptadores.repositorios.entidades;

import java.time.LocalDate;

import com.g5.t1cleanarch.dominio.entidades.PagamentoEntidade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Pagamento{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long codigo;
    @OneToOne(cascade = CascadeType.REFRESH)
    private Assinatura assinatura;
    private double valorPago;
    private LocalDate dataPagamento;
    private String promocao;

    protected Pagamento() {}

    public Pagamento(long codigo, Assinatura assinatura, double valorPago, LocalDate dataPagamento, String promocao) {
        this.codigo = codigo;
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public Pagamento(Assinatura assinatura, double valorPago, LocalDate dataPagamento, String promocao) {
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public long getCodigo() {
        return codigo;
    }

    public Assinatura getAssinatura() {
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

    public void setAssinatura(Assinatura assinatura) {
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

    public static Pagamento fromPagamentoEntidade(PagamentoEntidade pEntidade) {
        return new Pagamento(
            pEntidade.getCodigo(), 
            Assinatura.fromAssinaturaEntidade(pEntidade.getAssinatura()),
            pEntidade.getValorPago(),
            pEntidade.getDataPagamento(),
            pEntidade.getPromocao()
        );
    }

    public static PagamentoEntidade toPagamentoEntidade(Pagamento pagamento) {
        return new PagamentoEntidade(
            pagamento.getCodigo(), 
            Assinatura.toAssinaturaEntidade(pagamento.getAssinatura()),
            pagamento.getValorPago(),
            pagamento.getDataPagamento(),
            pagamento.getPromocao()
        );
    } 
}