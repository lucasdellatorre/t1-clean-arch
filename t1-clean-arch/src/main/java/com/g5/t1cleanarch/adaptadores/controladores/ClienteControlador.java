package com.g5.t1cleanarch.adaptadores.controladores;

import org.springframework.web.bind.annotation.RestController;

import com.g5.t1cleanarch.aplicacao.casosDeUso.CriaAssinaturaUC;
import com.g5.t1cleanarch.aplicacao.casosDeUso.ListaAplicativosUC;
import com.g5.t1cleanarch.aplicacao.casosDeUso.ListaClientesUC;
import com.g5.t1cleanarch.aplicacao.dtos.AplicativoDTO;
import com.g5.t1cleanarch.aplicacao.dtos.AssinaturaDTO;
import com.g5.t1cleanarch.aplicacao.dtos.ClienteDTO;
import com.g5.t1cleanarch.aplicacao.dtos.CriaAssinaturaRequisicaoDTO;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ClienteControlador {
    private ListaClientesUC listaClientes;
    private ListaAplicativosUC listaAplicativos;
    private CriaAssinaturaUC criaAssinatura;

    public ClienteControlador(
        ListaClientesUC listaClientesUC,
        ListaAplicativosUC listaAplicativosUC,
        CriaAssinaturaUC criaAssinaturaUC
        ) {
        this.listaClientes = listaClientesUC;
        this.listaAplicativos = listaAplicativosUC;
        this.criaAssinatura = criaAssinaturaUC;
    }

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String welcomeMessage() {
        return("T1 PROJARQ");
    }

    @GetMapping("servcad/clientes")
    @CrossOrigin(origins = "*")
    public List<ClienteDTO> listaClientes(){
        return listaClientes.run();
    }   
    
    @GetMapping("servcad/aplicativos")
    @CrossOrigin(origins = "*")
    public List<AplicativoDTO> listaAplicativos(){
        return listaAplicativos.run();
    }   

    @PostMapping("servcad/assinaturas")
    @CrossOrigin(origins = "*")
    public AssinaturaDTO criaAssinatura(@RequestBody CriaAssinaturaRequisicaoDTO assinatura) {
        return criaAssinatura.run(assinatura);
    }
}