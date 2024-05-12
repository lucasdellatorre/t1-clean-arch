package com.g5.t1cleanarch.adaptadores.repositorios.h2;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.g5.t1cleanarch.dominio.entidades.AplicativoEntidade;
import com.g5.t1cleanarch.dominio.repositorios.IAplicativoRepositorio;

@Repository
public class AplicativoRepositorio implements IAplicativoRepositorio {
    private JdbcTemplate jdbcTemplate;

    public AplicativoRepositorio(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<AplicativoEntidade> todos() {
          List<AplicativoEntidade> aplicativos = this.jdbcTemplate.query("SELECT * from aplicativos",
            (rs, rowNum) -> new AplicativoEntidade(
                rs.getInt("codigo"), 
                rs.getString("nome"),
                rs.getDouble("custoMensal")));
        return aplicativos;
    }
}