package com.g5.t1cleanarch.adaptadores.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import com.g5.t1cleanarch.adaptadores.repositorios.entidades.Aplicativo;

public interface AplicativoJPA_ItfRep extends CrudRepository<Aplicativo, Long> {
    @Override
    @NonNull
    List<Aplicativo> findAll();
    Aplicativo findById(long codigo);
}