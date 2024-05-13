package com.g5.t1cleanarch.adaptadores.repositorios.h2;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
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

    public AssinaturaEntidade cadastra(ClienteEntidade cliente, AplicativoEntidade aplicativo) {
        LocalDate dataAtual = LocalDate.now();

        LocalDate dataAtualMais30Dias = dataAtual.plusDays(30);

        // List<Object> splitUpNames = Arrays.asList(cliente.getCodigo(), aplicativo.getCodigo(), dataAtual, dataAtualMais30Dias)
        //     .stream()
        //     .collect(Collectors.toList());

        // // SimpleJdbcInsert s = new SimpleJdbcInsert(jdbcTemplate).withTableName("assinatura");

        // int codAssinatura = this.jdbcTemplate.update("INSERT INTO assinaturas(codigo_aplicativo, codigo_cliente, data_inicio, data_expiracao) values (?, ?, ?, ?)", splitUpNames);
        
        Map<String, Object> parameters = new HashMap<>();

        parameters.put("codigo_aplicativo", aplicativo.getCodigo());
        parameters.put("codigo_cliente", cliente.getCodigo());
        parameters.put("data_inicio", dataAtual);
        parameters.put("data_expiracao", dataAtualMais30Dias);

        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
            .withTableName("ASSINATURAS")
            .usingGeneratedKeyColumns("CODIGO");

        int codAssinatura = (int) simpleJdbcInsert.executeAndReturnKey(parameters);

        return new AssinaturaEntidade(codAssinatura, aplicativo, cliente, dataAtual, dataAtualMais30Dias);
    }
}
