package com.g5.t1cleanarch.adaptadores.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

import com.g5.t1cleanarch.adaptadores.repositorios.entidades.Assinatura;

public interface AssinaturaJPA_ItfRep extends CrudRepository<Assinatura, Long> {
    @Override
    @NonNull
    List<Assinatura> findAll();
    Assinatura findById(long codigo);

    @Query("SELECT a FROM Assinatura a WHERE a.cliente.codigo = :clienteCodigo")
    List<Assinatura> findByClienteCodigo(@Param("clienteCodigo") long clienteCodigo);

    @Query("SELECT a FROM Assinatura a WHERE a.aplicativo.codigo = :aplicativoCodigo")
    List<Assinatura> findByAplicativoCodigo(@Param("aplicativoCodigo") long aplicativoCodigo);
    
    @Query("SELECT a FROM Assinatura a WHERE a.fimVigencia < CURRENT_DATE")
    List<Assinatura> findAllAssinaturasCanceladas();

    @Query("SELECT a FROM Assinatura a WHERE a.fimVigencia >= CURRENT_DATE")
    List<Assinatura> findAllAssinaturasAtivas();
}