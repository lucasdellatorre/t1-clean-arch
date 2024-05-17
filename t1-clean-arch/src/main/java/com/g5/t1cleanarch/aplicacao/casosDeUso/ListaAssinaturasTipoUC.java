package com.g5.t1cleanarch.aplicacao.casosDeUso;
import org.springframework.stereotype.Service;
import java.util.List;
import com.g5.t1cleanarch.aplicacao.dtos.AssinaturaDTO;
import com.g5.t1cleanarch.dominio.servicos.ServicoDeAssinatura;

@Service
public class ListaAssinaturasTipoUC {
    private ServicoDeAssinatura servicoDeAssinatura;

    public ListaAssinaturasTipoUC(ServicoDeAssinatura servicoDeAssinatura) {
        this.servicoDeAssinatura = servicoDeAssinatura;
    }

    public List<AssinaturaDTO> run(String tipo) {
        return servicoDeAssinatura.listarAssinaturasPorTipo(tipo).stream()
            .map(a -> AssinaturaDTO.fromEntity(a))
            .toList(); 
    }
}
