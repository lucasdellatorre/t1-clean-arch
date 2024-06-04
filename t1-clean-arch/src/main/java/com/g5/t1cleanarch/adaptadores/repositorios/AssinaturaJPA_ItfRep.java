package com.g5.t1cleanarch.adaptadores.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AssinaturaJPA_ItfRep extends CrudRepository<Assinatura, Long> {
    List<Assinatura> findAll();
    Assinatura findById(long codigo);

    @Query("SELECT a FROM Assinatura a WHERE a.cliente.codigo = :clienteCodigo")
    List<Assinatura> findByClienteCodigo(@Param("clienteCodigo") long clienteCodigo);
}