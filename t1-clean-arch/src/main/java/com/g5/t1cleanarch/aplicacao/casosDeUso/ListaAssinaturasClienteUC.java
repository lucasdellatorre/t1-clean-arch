package com.g5.t1cleanarch.aplicacao.casosDeUso;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.g5.t1cleanarch.aplicacao.dtos.AssinaturaStatusDTO;
import com.g5.t1cleanarch.dominio.entidades.AssinaturaEntidade;
import com.g5.t1cleanarch.dominio.enums.Status;
import com.g5.t1cleanarch.dominio.servicos.ServicoDeAssinatura;

@Component
public class ListaAssinaturasClienteUC {
    private ServicoDeAssinatura servicoDeAssinatura;

    public ListaAssinaturasClienteUC(ServicoDeAssinatura servicoDeAssinatura) {
        this.servicoDeAssinatura = servicoDeAssinatura;
    }

    public List<AssinaturaStatusDTO> run(long codigo) {
        List<AssinaturaEntidade> assinaturas = servicoDeAssinatura.getAssinaturasCliente(codigo);
        List<AssinaturaStatusDTO> assinaturasDTO = new ArrayList<>();

        for (AssinaturaEntidade assinatura : assinaturas) {
            boolean valida = servicoDeAssinatura.verificarAssinaturaInvalida(assinatura);
            Status status;

            if (valida) {
                status = Status.ATIVA;
            }
            else {
                status = Status.CANCELADA;
            }

            AssinaturaStatusDTO aDTO = new AssinaturaStatusDTO(
                assinatura.getCodigo(),
                assinatura.getAplicativo(),
                assinatura.getCliente(),
                assinatura.getInicioVigencia(),
                assinatura.getFimVigencia(),
                status);

            assinaturasDTO.add(aDTO);
        }

        return assinaturasDTO;
    }
}