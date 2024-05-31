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

    public ListaAssinaturasClienteUC(ServicoDeAssinatura servicoDeAssinatura, AssinaturaInvalidaUC assinaturaInvalidaUC) {
        this.servicoDeAssinatura = servicoDeAssinatura;
    }

    public List<AssinaturaStatusDTO> run(long codigo) {
        List<AssinaturaEntidade> assinaturas = servicoDeAssinatura.getAssinaturasCliente(codigo);
        List<AssinaturaStatusDTO> assinaturasDTO = new ArrayList<>();

        for (AssinaturaEntidade a: assinaturas) {
            boolean valida = servicoDeAssinatura.verificarAssinaturaInvalida(a.getCodigo());
            Status status;

            if (valida) {
                status = Status.ATIVA;
            }
            else {
                status = Status.CANCELADA;
            }
            AssinaturaStatusDTO aDTO = new AssinaturaStatusDTO(
                a.getCodigo(),
                a.getAplicativo(),
                a.getCliente(),
                a.getInicioVigencia(),
                a.getFimVigencia(),
                status);

            assinaturasDTO.add(aDTO);
        }

        return assinaturasDTO;
    }
}