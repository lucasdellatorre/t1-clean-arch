package com.g5.t1cleanarch.aplicacao.casosDeUso;

import org.springframework.stereotype.Component;

import com.g5.t1cleanarch.dominio.servicos.ServicoDeAssinatura;

@Component
public class AssinaturaInvalidaUC {
    private ServicoDeAssinatura servicoDeAssinatura;

    public AssinaturaInvalidaUC(ServicoDeAssinatura servicoDeAssinatura) {
        this.servicoDeAssinatura = servicoDeAssinatura;
    }

    public boolean run(long codigo) {
        return servicoDeAssinatura.verificarAssinaturaInvalida(codigo);
    }
}
