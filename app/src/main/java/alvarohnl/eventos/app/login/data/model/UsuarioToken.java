package alvarohnl.eventos.app.login.data.model;

public class UsuarioToken {

    private String token;
    private String tempoExpirar;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTempoExpirar() {
        return tempoExpirar;
    }

    public void setTempoExpirar(String tempoExpirar) {
        this.tempoExpirar = tempoExpirar;
    }

}
