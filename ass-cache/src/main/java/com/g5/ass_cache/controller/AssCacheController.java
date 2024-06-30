package com.g5.ass_cache.controller;

import com.g5.ass_cache.service.AssCacheService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ass-cache")
public class AssCacheController {

    private final AssCacheService assCacheService;

    public AssCacheController(AssCacheService assCacheService) {
        this.assCacheService = assCacheService;
    }

    @GetMapping("/check/{assinaturaId}")
    public boolean checkAssinatura(@PathVariable int assinaturaId) {
        return assCacheService.checkAssinatura(assinaturaId);
    }

    @PostMapping("/update/{assinaturaId}")
    public void updateAssinatura(@PathVariable int assinaturaId) {
        assCacheService.updateAssinatura(assinaturaId);
    }
}
