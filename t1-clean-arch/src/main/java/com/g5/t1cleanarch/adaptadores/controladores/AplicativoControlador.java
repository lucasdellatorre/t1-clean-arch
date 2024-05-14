package com.g5.t1cleanarch.adaptadores.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.g5.t1cleanarch.aplicacao.casosDeUso.AtualizaCustoUC;
import com.g5.t1cleanarch.aplicacao.casosDeUso.ListaAplicativosUC;
import com.g5.t1cleanarch.aplicacao.dtos.AplicativoDTO;
import com.g5.t1cleanarch.aplicacao.dtos.AtualizaCustoMensalRequisicaoDTO;

@RestController
public class AplicativoControlador {
    private ListaAplicativosUC listaAplicativos;
    private AtualizaCustoUC atualizaCustoUC;

    public AplicativoControlador(ListaAplicativosUC listaAplicativosUC, AtualizaCustoUC atualizaCustoUC) {
        this.listaAplicativos = listaAplicativosUC;
        this.atualizaCustoUC = atualizaCustoUC;
    }

    @GetMapping("servcad/aplicativos")
    @CrossOrigin(origins = "*")
    public List<AplicativoDTO> listaAplicativos(){
        return listaAplicativos.run();
    }  

    
    @PostMapping("servcad/aplicativos/atualizacusto/{idAplicativo}")
    @CrossOrigin(origins = "*")
    public AplicativoDTO atualizaCustoMensal(
        @PathVariable(value="idAplicativo") long idAplicativo, 
        @RequestBody AtualizaCustoMensalRequisicaoDTO atualizaCustoMensalRequisicaoDTO) {

        return atualizaCustoUC.run(idAplicativo, atualizaCustoMensalRequisicaoDTO);
    }
}
