package com.g5.t1cleanarch.dominio.entidades;

public class UsuarioEntidade{
    private String usuario;
    private String senha;

    public UsuarioEntidade(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Cliente [usuario=" + usuario + ", senha=" + senha + "]";
    }
}