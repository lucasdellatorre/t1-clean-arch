package com.g5.t1cleanarch.adaptadores.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import com.g5.t1cleanarch.adaptadores.repositorios.entidades.Cliente;

public interface ClienteJPA_ItfRep extends CrudRepository<Cliente, Long>{
    @Override
    @NonNull
    List<Cliente> findAll();
    Cliente findById(long codigo);
}