package com.g5.t1cleanarch.adaptadores.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.g5.t1cleanarch.adaptadores.repositorios.entidades.Pagamento;

public interface PagamentoJPA_ItfRep extends CrudRepository<Pagamento, Long> {
    
}
