package com.g5.t1cleanarch.adaptadores.controladores;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.g5.t1cleanarch.aplicacao.casosDeUso.RegistraPagamentoUC;
import com.g5.t1cleanarch.aplicacao.dtos.RegistraPagamentoDTO;
import com.g5.t1cleanarch.aplicacao.dtos.RegistraPagamentoRequisicaoDTO;
import com.g5.t1cleanarch.rabbitmq.RabbitMQConfig;

@RestController
public class PagamentoControlador {
    RegistraPagamentoUC registraPagamentoUC;
    RabbitTemplate rabbitTemplate;

    public PagamentoControlador(RegistraPagamentoUC registraPagamentoUC, RabbitTemplate rabbitTemplate) {
        this.registraPagamentoUC = registraPagamentoUC;
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("registrarPagamento")
    @CrossOrigin(origins = "*")
    public RegistraPagamentoDTO criaAssinatura(@RequestBody RegistraPagamentoRequisicaoDTO pagamento) {
        RegistraPagamentoDTO result = registraPagamentoUC.run(pagamento);
        rabbitTemplate.convertAndSend(RabbitMQConfig.DELETE_QUEUE, pagamento.getCodass());
        return result;
    }
}