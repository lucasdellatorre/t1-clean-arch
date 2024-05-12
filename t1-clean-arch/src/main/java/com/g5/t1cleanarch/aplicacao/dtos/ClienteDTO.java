package com.g5.t1cleanarch.aplicacao.dtos;

import com.g5.t1cleanarch.dominio.entidades.ClienteEntidade;

public class ClienteDTO{
    private long codigo;
    private String nome;
    private String email;

    public ClienteDTO(long codigo, String nome, String email) {
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

    public static ClienteDTO fromEntity(ClienteEntidade cliente){
        return new ClienteDTO(cliente.getCodigo(), cliente.getNome(), cliente.getEmail());
    }
}