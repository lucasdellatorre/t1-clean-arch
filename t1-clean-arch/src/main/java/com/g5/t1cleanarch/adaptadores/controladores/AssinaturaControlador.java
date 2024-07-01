package com.g5.t1cleanarch.adaptadores.controladores;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.g5.t1cleanarch.aplicacao.casosDeUso.AssinaturaInvalidaUC;
import com.g5.t1cleanarch.aplicacao.casosDeUso.CriaAssinaturaUC;
import com.g5.t1cleanarch.aplicacao.casosDeUso.ListaAssinaturasAplicativoUC;
import com.g5.t1cleanarch.aplicacao.casosDeUso.ListaAssinaturasClienteUC;
import com.g5.t1cleanarch.aplicacao.casosDeUso.ListaAssinaturasTipoUC;
import com.g5.t1cleanarch.aplicacao.dtos.AssinaturaDTO;
import com.g5.t1cleanarch.aplicacao.dtos.AssinaturaStatusDTO;
import com.g5.t1cleanarch.aplicacao.dtos.CriaAssinaturaRequisicaoDTO;
import com.g5.t1cleanarch.rabbitmq.RabbitMQConfig;
import com.g5.t1cleanarch.rabbitmq.ResponseListener;

@RestController
public class AssinaturaControlador {
    private CriaAssinaturaUC criaAssinatura;
    private ListaAssinaturasTipoUC listaAssinaturasTipo;
    private ListaAssinaturasClienteUC listaAssinaturasCliente;
    private AssinaturaInvalidaUC assinaturaInvalida;
    private ListaAssinaturasAplicativoUC listaAssinaturasAplicativo;
    private RabbitTemplate rabbitTemplate;

    public AssinaturaControlador(
        CriaAssinaturaUC criaAssinaturaUC, 
        ListaAssinaturasTipoUC listaAssinaturasTipo,
        ListaAssinaturasClienteUC listaAssinaturasCliente,
        ListaAssinaturasAplicativoUC listaAssinaturasAplicativo,
        AssinaturaInvalidaUC assinaturaInvalida,
        RabbitTemplate rabbitTemplate
        ) {
        this.criaAssinatura = criaAssinaturaUC;
        this.listaAssinaturasTipo = listaAssinaturasTipo;
        this.listaAssinaturasCliente = listaAssinaturasCliente;
        this.assinaturaInvalida = assinaturaInvalida;
        this.listaAssinaturasAplicativo = listaAssinaturasAplicativo;
        this.rabbitTemplate = rabbitTemplate;
    }
  
    @PostMapping("servcad/assinaturas")
    @CrossOrigin(origins = "*")
    public AssinaturaDTO criaAssinatura(@RequestBody CriaAssinaturaRequisicaoDTO assinatura) {
        return criaAssinatura.run(assinatura);
    }

    @GetMapping("servcad/assinaturas/{tipo}")
    @CrossOrigin(origins = "*")
    public List<AssinaturaStatusDTO> listarAssinaturasPorTipo(@PathVariable String tipo) {
        return listaAssinaturasTipo.run(tipo);
    }
    
    @GetMapping("servcad/asscli/{codcli}")
    @CrossOrigin(origins = "*")
    public List<AssinaturaStatusDTO> listaAssinaturasCliente(@PathVariable(value="codcli") long codcli) {
        return listaAssinaturasCliente.run(codcli);
    }

    @GetMapping("servcad/assapp/{codapp}")
    @CrossOrigin(origins = "*")
    public List<AssinaturaStatusDTO> listaAssinaturasAplicativo(@PathVariable(value="codapp") long codapp) {
        return listaAssinaturasAplicativo.run(codapp);
    }

    @GetMapping("assinvalida/{codass}")
    @CrossOrigin(origins = "*")
    public boolean verificaAssinaturaValida(@PathVariable(value="codass") long codass) {
        ResponseListener.reset();
        rabbitTemplate.convertAndSend(RabbitMQConfig.REQUEST_QUEUE, codass);
        int retries = 3;
        while (!ResponseListener.isResponseReceived() && retries > 0) {
            try {
                Thread.sleep(100); // Aguarda 100ms entre tentativas
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread interrupted", e);
            }
            retries--;
        }
        if (ResponseListener.isResponseReceived()) {
            return ResponseListener.getCacheResponse();
        } else {
            boolean isInvalid = assinaturaInvalida.run(codass);
            rabbitTemplate.convertAndSend(RabbitMQConfig.UPDATE_QUEUE, new Object[]{codass, isInvalid});
            return isInvalid;
        }

    }
}