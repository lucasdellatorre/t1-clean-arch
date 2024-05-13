package com.g5.t1cleanarch.adaptadores.controladores;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.g5.t1cleanarch.aplicacao.casosDeUso.CriaAssinaturaUC;
import com.g5.t1cleanarch.aplicacao.dtos.AssinaturaDTO;
import com.g5.t1cleanarch.aplicacao.dtos.CriaAssinaturaRequisicaoDTO;

@RestController
public class AssinaturaControlador {
    private CriaAssinaturaUC criaAssinatura;

    public AssinaturaControlador(CriaAssinaturaUC criaAssinaturaUC) {
        this.criaAssinatura = criaAssinaturaUC;
    }

    @PostMapping("servcad/assinaturas")
    @CrossOrigin(origins = "*")
    public AssinaturaDTO criaAssinatura(@RequestBody CriaAssinaturaRequisicaoDTO assinatura) {
        return criaAssinatura.run(assinatura);
    }
}