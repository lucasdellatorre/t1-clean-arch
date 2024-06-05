package com.g5.t1cleanarch.adaptadores.controladores;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.g5.t1cleanarch.aplicacao.casosDeUso.RegistraPagamentoUC;
import com.g5.t1cleanarch.aplicacao.dtos.RegistraPagamentoDTO;
import com.g5.t1cleanarch.aplicacao.dtos.RegistraPagamentoRequisicaoDTO;

@RestController
public class PagamentoControlador {
    RegistraPagamentoUC registraPagamentoUC;

    public PagamentoControlador(RegistraPagamentoUC registraPagamentoUC) {
        this.registraPagamentoUC = registraPagamentoUC;
    }

    @PostMapping("registrarPagamento")
    @CrossOrigin(origins = "*")
    public RegistraPagamentoDTO criaAssinatura(@RequestBody RegistraPagamentoRequisicaoDTO pagamento) {
        return registraPagamentoUC.run(pagamento);
    }
}