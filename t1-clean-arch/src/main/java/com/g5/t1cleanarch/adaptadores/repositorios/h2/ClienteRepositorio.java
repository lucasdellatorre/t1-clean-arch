package com.g5.t1cleanarch.adaptadores.repositorios.h2;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.g5.t1cleanarch.dominio.entidades.ClienteEntidade;
import com.g5.t1cleanarch.dominio.repositorios.IClienteRepositorio;

@Repository
public class ClienteRepositorio implements IClienteRepositorio {
    private JdbcTemplate jdbcTemplate;

    public ClienteRepositorio(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ClienteEntidade> todos(){
        List<ClienteEntidade> clientes = this.jdbcTemplate.query("SELECT * from clientes",
            (rs, rowNum) -> new ClienteEntidade(
                rs.getInt("codigo"), 
                rs.getString("nome"),
                rs.getString("email")));
        return clientes;
    }
}