package com.g5.t1cleanarch.adaptadores.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.g5.t1cleanarch.aplicacao.casosDeUso.CriaAssinaturaUC;
import com.g5.t1cleanarch.aplicacao.casosDeUso.ListaAssinaturasTipoUC;
import com.g5.t1cleanarch.aplicacao.dtos.AssinaturaDTO;
import com.g5.t1cleanarch.aplicacao.dtos.CriaAssinaturaRequisicaoDTO;

@RestController
public class AssinaturaControlador {
    private CriaAssinaturaUC criaAssinatura;
    private ListaAssinaturasTipoUC listaAssinaturasTipoUC;

    public AssinaturaControlador(CriaAssinaturaUC criaAssinaturaUC, ListaAssinaturasTipoUC listaAssinaturasTipoUC) {
        this.criaAssinatura = criaAssinaturaUC;
        this.listaAssinaturasTipoUC = listaAssinaturasTipoUC;
    }

    @PostMapping("servcad/assinaturas")
    @CrossOrigin(origins = "*")
    public AssinaturaDTO criaAssinatura(@RequestBody CriaAssinaturaRequisicaoDTO assinatura) {
        return criaAssinatura.run(assinatura);
    }

    @GetMapping("servcad/assinaturas/{tipo}")
    @CrossOrigin(origins = "*")
    public List<AssinaturaDTO> listarAssinaturasPorTipo(@PathVariable String tipo) {
        return listaAssinaturasTipoUC.run(tipo);
    }
}