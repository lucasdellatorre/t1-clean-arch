package com.g5.t1cleanarch.aplicacao.casosDeUso;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import com.g5.t1cleanarch.aplicacao.dtos.AssinaturaDTO;
import com.g5.t1cleanarch.aplicacao.dtos.AssinaturaStatusDTO;
import com.g5.t1cleanarch.dominio.entidades.AssinaturaEntidade;
import com.g5.t1cleanarch.dominio.enums.Status;
import com.g5.t1cleanarch.dominio.servicos.ServicoDeAssinatura;

@Service
public class ListaAssinaturasTipoUC {
    private ServicoDeAssinatura servicoDeAssinatura;

    public ListaAssinaturasTipoUC(ServicoDeAssinatura servicoDeAssinatura) {
        this.servicoDeAssinatura = servicoDeAssinatura;
    }

    public List<AssinaturaStatusDTO> run(String tipo) {
        List<AssinaturaEntidade> assinaturas = servicoDeAssinatura.listarAssinaturasPorTipo(tipo);
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
