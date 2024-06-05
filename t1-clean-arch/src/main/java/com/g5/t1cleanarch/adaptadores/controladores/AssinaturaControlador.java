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
import com.g5.t1cleanarch.aplicacao.casosDeUso.ListaAssinaturasClienteUC;
import com.g5.t1cleanarch.aplicacao.casosDeUso.ListaAssinaturasTipoUC;
import com.g5.t1cleanarch.aplicacao.dtos.AssinaturaDTO;
import com.g5.t1cleanarch.aplicacao.dtos.AssinaturaStatusDTO;
import com.g5.t1cleanarch.aplicacao.dtos.CriaAssinaturaRequisicaoDTO;

@RestController
public class AssinaturaControlador {
    private CriaAssinaturaUC criaAssinatura;
    private ListaAssinaturasTipoUC listaAssinaturasTipo;
    private ListaAssinaturasClienteUC listaAssinaturasCliente;
    private AssinaturaInvalidaUC assinaturaInvalida;

    public AssinaturaControlador(CriaAssinaturaUC criaAssinaturaUC, ListaAssinaturasTipoUC listaAssinaturasTipoUC, ListaAssinaturasClienteUC listaAssinaturasClienteUC, AssinaturaInvalidaUC assinaturaInvalidaUC) {
        this.criaAssinatura = criaAssinaturaUC;
        this.listaAssinaturasTipo = listaAssinaturasTipoUC;
        this.listaAssinaturasCliente = listaAssinaturasClienteUC;
        this.assinaturaInvalida = assinaturaInvalidaUC;
    }

    @PostMapping("servcad/assinaturas")
    @CrossOrigin(origins = "*")
    public AssinaturaDTO criaAssinatura(@RequestBody CriaAssinaturaRequisicaoDTO assinatura) {
        return criaAssinatura.run(assinatura);
    }

    @GetMapping("servcad/assinaturas/{tipo}")
    @CrossOrigin(origins = "*")
    public List<AssinaturaStatusDTO> listarAssinaturasPorTipo(@PathVariable String tipo) {
        return listaAssinaturasTipo.run(tipo);
    }
    
    @GetMapping("servcad/asscli/{codcli}")
    @CrossOrigin(origins = "*")
    public List<AssinaturaStatusDTO> listaAssinaturasCliente(@PathVariable(value="codcli") long codcli) {
        return listaAssinaturasCliente.run(codcli);
    }

    @GetMapping("assinvalida/{codass}")
    @CrossOrigin(origins = "*")
    public boolean verificaAssinaturaValida(@PathVariable(value="codass") long codass) {
        return assinaturaInvalida.run(codass);

    }
}