package com.g5.t1cleanarch.adaptadores.repositorios.h2;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.g5.t1cleanarch.dominio.entidades.ClienteEntidade;
import com.g5.t1cleanarch.dominio.entidades.AplicativoEntidade;
import com.g5.t1cleanarch.dominio.entidades.AssinaturaEntidade;
import com.g5.t1cleanarch.dominio.repositorios.IAssinaturaRepositorio;

@Repository
public class AssinaturaRepositorio implements IAssinaturaRepositorio {
    private JdbcTemplate jdbcTemplate;

    public AssinaturaRepositorio(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public AssinaturaEntidade cadastra(ClienteEntidade cliente, AplicativoEntidade aplicativo, LocalDate dataAtual, LocalDate dataExpiracao) {
        Map<String, Object> parameters = new HashMap<>();

        parameters.put("codigo_aplicativo", aplicativo.getCodigo());
        parameters.put("codigo_cliente", cliente.getCodigo());
        parameters.put("data_inicio", dataAtual);
        parameters.put("data_expiracao", dataExpiracao);

        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
            .withTableName("ASSINATURAS")
            .usingGeneratedKeyColumns("CODIGO");

        int codAssinatura = (int) simpleJdbcInsert.executeAndReturnKey(parameters);

        return new AssinaturaEntidade(codAssinatura, aplicativo, cliente, dataAtual, dataExpiracao);
    }

    public List<AssinaturaEntidade> listarAssinaturasPorTipo(String tipo) {
        String query;
        LocalDate hoje = LocalDate.now();
        RowMapper<AssinaturaEntidade> rowMapper = (rs, rowNum) -> {

            AplicativoEntidade aplicativo = new AplicativoEntidade(
                rs.getLong("codigo_aplicativo"),
                null,
                0
            );
    
            ClienteEntidade cliente = new ClienteEntidade(
                rs.getLong("codigo_cliente"),
                null,
                null
            );

            return new AssinaturaEntidade(
                rs.getLong("codigo"),
                aplicativo,
                cliente,
                rs.getDate("data_inicio").toLocalDate(),
                rs.getDate("data_expiracao").toLocalDate()
            );
        };
        
        switch (tipo.toUpperCase()) {
            case "ATIVAS":
                query = "SELECT * FROM assinaturas WHERE data_expiracao > ?";
                return jdbcTemplate.query(query, rowMapper, hoje);
            case "CANCELADAS":
                query = "SELECT * FROM assinaturas WHERE data_expiracao <= ?";
                return jdbcTemplate.query(query, rowMapper, hoje);
            case "TODAS":
            default:
                query = "SELECT * FROM assinaturas";
                return jdbcTemplate.query(query, rowMapper);
        }
    }
}
