package alvarohnl.eventos.app.login.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioRequest {

    @JsonProperty("username")
    private String nomeUsuario;

    @JsonProperty("pass")
    private String senha;

    public UsuarioRequest(String nomeUsuario, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
