package com.g5.t1cleanarch.adaptadores.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AplicativoJPA_ItfRep extends CrudRepository<Aplicativo, Long> {
    List<Aplicativo> findAll();
    Aplicativo findById(long codigo);
}