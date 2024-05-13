package com.g5.t1cleanarch.aplicacao.casosDeUso;

import org.springframework.stereotype.Component;

import com.g5.t1cleanarch.aplicacao.dtos.AssinaturaDTO;
import com.g5.t1cleanarch.aplicacao.dtos.CriaAssinaturaRequisicaoDTO;
import com.g5.t1cleanarch.dominio.entidades.AplicativoEntidade;
import com.g5.t1cleanarch.dominio.entidades.AssinaturaEntidade;
import com.g5.t1cleanarch.dominio.entidades.ClienteEntidade;
import com.g5.t1cleanarch.dominio.servicos.ServicoDeAplicativos;
import com.g5.t1cleanarch.dominio.servicos.ServicoDeAssinatura;
import com.g5.t1cleanarch.dominio.servicos.ServicoDeClientes;

@Component
public class CriaAssinaturaUC {
    private ServicoDeAssinatura servicoDeAssinatura;
    private ServicoDeAplicativos servicoDeAplicativos;
    private ServicoDeClientes servicoDeClientes;

    public CriaAssinaturaUC(
        ServicoDeAssinatura servicoDeAssinatura,
        ServicoDeAplicativos servicoDeAplicativos,
        ServicoDeClientes servicoDeClientes
        ) {
        this.servicoDeAssinatura = servicoDeAssinatura;
        this.servicoDeAplicativos = servicoDeAplicativos;
        this.servicoDeClientes = servicoDeClientes;
    }

    public AssinaturaDTO run(CriaAssinaturaRequisicaoDTO criaAssinaturaReq) {
        long codCliente = criaAssinaturaReq.getCodigoCliente();
        long codAplicativo = criaAssinaturaReq.getCodigoAplicativo();

        ClienteEntidade cliente = this.servicoDeClientes.getClientePorCodigo(codCliente);
        AplicativoEntidade aplicativo = this.servicoDeAplicativos.getAplicativoPorCodigo(codAplicativo);

        if (cliente == null || aplicativo == null) {
            return null;
        } 

        AssinaturaEntidade assinatura = servicoDeAssinatura.criaAssinatura(cliente, aplicativo);
        return AssinaturaDTO.fromEntity(assinatura);
    }
}
