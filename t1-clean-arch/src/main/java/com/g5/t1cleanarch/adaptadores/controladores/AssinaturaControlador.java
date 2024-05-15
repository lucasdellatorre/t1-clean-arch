package com.g5.t1cleanarch.adaptadores.controladores;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.g5.t1cleanarch.aplicacao.casosDeUso.AssinaturaInvalidaUC;
import com.g5.t1cleanarch.aplicacao.casosDeUso.CriaAssinaturaUC;
import com.g5.t1cleanarch.aplicacao.dtos.AssinaturaDTO;
import com.g5.t1cleanarch.aplicacao.dtos.CriaAssinaturaRequisicaoDTO;

@RestController
public class AssinaturaControlador {
    private CriaAssinaturaUC criaAssinatura;
    private AssinaturaInvalidaUC assinaturaInvalida;

    public AssinaturaControlador(CriaAssinaturaUC criaAssinaturaUC, AssinaturaInvalidaUC assinaturaInvalida) {
        this.criaAssinatura = criaAssinaturaUC;
        this.assinaturaInvalida = assinaturaInvalida;
    }

    @PostMapping("servcad/assinaturas")
    @CrossOrigin(origins = "*")
    public AssinaturaDTO criaAssinatura(@RequestBody CriaAssinaturaRequisicaoDTO assinatura) {
        return criaAssinatura.run(assinatura);
    }

    @GetMapping("assinvalida/{codass}")
    @CrossOrigin(origins = "*")
    public boolean verificaAssinaturaValida(@PathVariable(value="codass") long codass) {
        return assinaturaInvalida.run(codass);
    }
}