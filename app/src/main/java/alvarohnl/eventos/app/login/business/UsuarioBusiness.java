package alvarohnl.eventos.app.login.business;

import alvarohnl.eventos.app.login.data.model.UsuarioToken;

public interface UsuarioBusiness {

    boolean isUsuarioValido(String usuario);

    boolean isSenhaValida(String senha);

    void salvarUserToken(UsuarioToken usuarioToken) throws Exception;

}
