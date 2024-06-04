package com.g5.t1cleanarch.adaptadores.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ClienteJPA_ItfRep extends CrudRepository<Cliente, Long>{
    List<Cliente> findAll();
    Cliente findById(long codigo);
}