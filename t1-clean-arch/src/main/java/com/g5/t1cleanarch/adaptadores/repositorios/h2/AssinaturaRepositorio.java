package com.g5.t1cleanarch.adaptadores.repositorios.h2;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
// import java.time.LocalDate;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
// import org.springframework.stereotype.Repository;

// import com.g5.t1cleanarch.dominio.entidades.ClienteEntidade;
// import com.g5.t1cleanarch.dominio.entidades.AplicativoEntidade;
// import com.g5.t1cleanarch.dominio.entidades.AssinaturaEntidade;
// import com.g5.t1cleanarch.dominio.repositorios.IAssinaturaRepositorio;

// @Repository
// public class AssinaturaRepositorio implements IAssinaturaRepositorio {
//     private JdbcTemplate jdbcTemplate;

//     public AssinaturaRepositorio(JdbcTemplate jdbcTemplate) {
//         this.jdbcTemplate = jdbcTemplate;
//     }

//     public AssinaturaEntidade cadastra(ClienteEntidade cliente, AplicativoEntidade aplicativo, LocalDate dataAtual, LocalDate dataExpiracao) {
//         Map<String, Object> parameters = new HashMap<>();

//         parameters.put("codigo_aplicativo", aplicativo.getCodigo());
//         parameters.put("codigo_cliente", cliente.getCodigo());
//         parameters.put("data_inicio", dataAtual);
//         parameters.put("data_expiracao", dataExpiracao);

//         SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
//             .withTableName("ASSINATURAS")
//             .usingGeneratedKeyColumns("CODIGO");

//         int codAssinatura = (int) simpleJdbcInsert.executeAndReturnKey(parameters);

//         return new AssinaturaEntidade(codAssinatura, aplicativo, cliente, dataAtual, dataExpiracao);
//     }

//     public boolean verificarAssinaturaInvalida(long codigo, LocalDate dataAtual) {
//         int count = this.jdbcTemplate.queryForObject("SELECT COUNT(*) from assinaturas where codigo=" + codigo + " AND data_expiracao>='" + dataAtual + "'", 
//             Integer.class);

//         return count != 0;
//     }

//     public List<AssinaturaEntidade> getAssinaturasCliente(long codigo) {
//         List<AssinaturaEntidade> assinaturas = this.jdbcTemplate.query("SELECT * from assinaturas where codigo_cliente = " + codigo,
//             (rs, rowNum) -> {

//                 long codigoCliente = rs.getLong("codigo_cliente");
//                 long codigoAplicativo = rs.getLong("codigo_aplicativo");

//                 ClienteEntidade cliente = new ClienteEntidade(codigoCliente, null, null);
//                 AplicativoEntidade aplicativo = new AplicativoEntidade(codigoAplicativo, null, codigo);

//                 AssinaturaEntidade assinatura = new AssinaturaEntidade(
//                     rs.getLong("codigo"),
//                     aplicativo,
//                     cliente,
//                     rs.getDate("data_inicio").toLocalDate(),
//                     rs.getDate("data_expiracao").toLocalDate());

//                 return assinatura;
//         });
//         return assinaturas;
//     }
// }
