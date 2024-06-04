package com.g5.t1cleanarch.adaptadores.repositorios;

import com.g5.t1cleanarch.dominio.entidades.ClienteEntidade;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cliente {
    @Id
    private long codigo;
    private String nome;
    private String email;

    protected Cliente() {}

    public Cliente(long codigo, String nome, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente [codigo=" + codigo + ", nome=" + nome + ", email=" + email + "]";
    }

    public static Cliente fromClienteEntidade(ClienteEntidade cEntidade) {
        return new Cliente(cEntidade.getCodigo(), cEntidade.getNome(), cEntidade.getEmail());
    }

    public static ClienteEntidade toClienteEntidade(Cliente cliente) {
        return new ClienteEntidade(cliente.getCodigo(), cliente.getNome(), cliente.getEmail());
    }
}

