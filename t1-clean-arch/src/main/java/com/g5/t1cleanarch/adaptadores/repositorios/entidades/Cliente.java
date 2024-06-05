package com.g5.t1cleanarch.adaptadores.repositorios.entidades;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.g5.t1cleanarch.dominio.entidades.ClienteEntidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
      name = "sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "cliente_sequence"),
        @Parameter(name = "initial_value", value = "11"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
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

