package com.g5.ass_cache.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class AssCacheService {

    private final Map<Integer, Boolean> cache = new HashMap<>();
    private final RestTemplate restTemplate;

    public AssCacheService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean checkAssinatura(int assinaturaId) {
        if (cache.containsKey(assinaturaId)) {
            return cache.get(assinaturaId);
        } else {
            @SuppressWarnings("null")
            boolean response = restTemplate.getForObject("http://t1-clean-arch/assinvalida/" + assinaturaId, Boolean.class);
            cache.put(assinaturaId, response);
            return response;
        }
    }

    public void updateAssinatura(int assinaturaId) {
        cache.remove(assinaturaId);
    }
}
