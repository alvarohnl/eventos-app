package alvarohnl.eventos.app.login.data.model;

public class UsuarioToken {

    private String token;
    private Long tempoExpirar;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getTempoExpirar() {
        return tempoExpirar;
    }

    public void setTempoExpirar(Long tempoExpirar) {
        this.tempoExpirar = tempoExpirar;
    }

}
