package com.g5.t1cleanarch.adaptadores.controladores;

import org.springframework.web.bind.annotation.RestController;

import com.g5.t1cleanarch.aplicacao.casosDeUso.ListaClientesUC;
import com.g5.t1cleanarch.aplicacao.dtos.ClienteDTO;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ClienteControlador {
    private ListaClientesUC listaClientes;

    public ClienteControlador(ListaClientesUC listaClientesUC) {
        this.listaClientes = listaClientesUC;
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
}