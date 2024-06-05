package com.g5.t1cleanarch.adaptadores.repositorios.entidades;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.g5.t1cleanarch.dominio.entidades.AssinaturaEntidade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Assinatura {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
      name = "sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "assinatura_sequence"),
        @Parameter(name = "initial_value", value = "9"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
    private long codigo;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Aplicativo aplicativo;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Cliente cliente;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;

    protected Assinatura() {}

    public Assinatura(Aplicativo aplicativo, Cliente cliente, LocalDate dataAtual, LocalDate dataAtualMais30Dias) {
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.inicioVigencia = dataAtual;
        this.fimVigencia = dataAtualMais30Dias;
    }

    public Assinatura(long codigo, Aplicativo aplicativo, Cliente cliente, LocalDate dataAtual, LocalDate dataAtualMais30Dias) {
        this.codigo = codigo;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.inicioVigencia = dataAtual;
        this.fimVigencia = dataAtualMais30Dias;
    }

    public long getCodigo() {
        return codigo;
    }

    public Aplicativo getAplicativo() {
        return aplicativo;
    }

    public Cliente getCliente() {
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

    public void setAplicativo(Aplicativo aplicativo) {
        this.aplicativo = aplicativo;
    }

    public void setCliente(Cliente cliente) {
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

    public static Assinatura fromAssinaturaEntidade(AssinaturaEntidade aEntidade) {
        return new Assinatura(
                aEntidade.getCodigo(),
                Aplicativo.fromAplicativoEntidade(aEntidade.getAplicativo()), 
                Cliente.fromClienteEntidade(aEntidade.getCliente()), 
                aEntidade.getInicioVigencia(), 
                aEntidade.getFimVigencia());
    }

    public static AssinaturaEntidade toAssinaturaEntidade(Assinatura assinatura) {
        return new AssinaturaEntidade(
            assinatura.getCodigo(), 
            Aplicativo.toAplicativoEntidade(assinatura.getAplicativo()), 
            Cliente.toClienteEntidade(assinatura.getCliente()), 
            assinatura.getInicioVigencia(), 
            assinatura.getFimVigencia());
    }
}