package com.g5.t1cleanarch.adaptadores.controladores;

import org.springframework.web.bind.annotation.RestController;

import com.g5.t1cleanarch.aplicacao.casosDeUso.ListaAplicativosUC;
import com.g5.t1cleanarch.aplicacao.casosDeUso.ListaClientesUC;
import com.g5.t1cleanarch.aplicacao.dtos.AplicativoDTO;
import com.g5.t1cleanarch.aplicacao.dtos.ClienteDTO;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ClienteControlador {
    private ListaClientesUC listaClientes;
    private ListaAplicativosUC listaAplicativos;

    public ClienteControlador(
        ListaClientesUC listaClientesUC,
        ListaAplicativosUC listaAplicativosUC
        ) {
        this.listaClientes = listaClientesUC;
        this.listaAplicativos = listaAplicativosUC;
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
}