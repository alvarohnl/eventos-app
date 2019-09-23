package alvarohnl.eventos.app.login.business;

import alvarohnl.eventos.app.login.data.model.UsuarioToken;

public interface UsuarioBusiness {

    void salvarUsuarioToken(UsuarioToken usuarioToken);

    void removerUsuarioToken();

}
