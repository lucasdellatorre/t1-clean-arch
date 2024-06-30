package com.g5.ass_cache.controller;

import com.g5.ass_cache.rabbitmq.HistoryDTO;
import com.g5.ass_cache.service.AssCacheService;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ass-cache")
public class AssCacheController {

    private final AssCacheService assCacheService;
    private final RabbitTemplate rabbitTemplate;
    private final FanoutExchange fanoutExchange;

    public AssCacheController(AssCacheService assCacheService, RabbitTemplate rabbitTemplate, FanoutExchange fanoutExchange) {
        this.assCacheService = assCacheService;
        this.rabbitTemplate = rabbitTemplate;
        this.fanoutExchange = fanoutExchange;
    }

    @GetMapping("/check/{assinaturaId}")
    public boolean checkAssinatura(@PathVariable int assinaturaId) {
        HistoryDTO dto = new HistoryDTO(assinaturaId); 
        rabbitTemplate.convertAndSend(fanoutExchange.getName(), "", dto);
        return assCacheService.checkAssinatura(assinaturaId);
    }

    @PostMapping("/update/{assinaturaId}")
    public void updateAssinatura(@PathVariable int assinaturaId) {
        assCacheService.updateAssinatura(assinaturaId);
    }
}