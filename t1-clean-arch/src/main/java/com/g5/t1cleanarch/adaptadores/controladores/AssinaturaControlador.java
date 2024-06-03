package com.g5.t1cleanarch.adaptadores.controladores;

import java.util.List;

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
import com.g5.t1cleanarch.aplicacao.dtos.AssinaturaDTO;
import com.g5.t1cleanarch.aplicacao.dtos.AssinaturaStatusDTO;
import com.g5.t1cleanarch.aplicacao.dtos.CriaAssinaturaRequisicaoDTO;

@RestController
public class AssinaturaControlador {
    private CriaAssinaturaUC criaAssinatura;
    private AssinaturaInvalidaUC assinaturaInvalida;
    private ListaAssinaturasClienteUC listaAssinaturasCliente;
    private ListaAssinaturasAplicativoUC listaAssinaturasAplicativo;

    public AssinaturaControlador(CriaAssinaturaUC criaAssinaturaUC, AssinaturaInvalidaUC assinaturaInvalidaUC, ListaAssinaturasClienteUC listaAssinaturasClienteUC, ListaAssinaturasAplicativoUC listaAssinaturasAplicativoUC) {
        this.criaAssinatura = criaAssinaturaUC;
        this.assinaturaInvalida = assinaturaInvalidaUC;
        this.listaAssinaturasCliente = listaAssinaturasClienteUC;
        this.listaAssinaturasAplicativo = listaAssinaturasAplicativoUC;
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
}