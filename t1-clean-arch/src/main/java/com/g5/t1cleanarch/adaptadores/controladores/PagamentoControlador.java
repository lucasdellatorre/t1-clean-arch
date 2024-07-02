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
        System.out.println(pagamento.toString());
        RegistraPagamentoDTO result = registraPagamentoUC.run(pagamento);
        System.out.print("pagando assinatura " + pagamento.getCodass());
        long codass = pagamento.getCodass();
        rabbitTemplate.convertAndSend(RabbitMQConfig.DELETE_FANOUT_EXCHANGE, "", codass);
        return result;
    }
}