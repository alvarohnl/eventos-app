package alvarohnl.eventos.app.login.business;

import alvarohnl.eventos.app.login.data.model.UsuarioToken;

public class UsuarioBusinessImpl implements UsuarioBusiness {

    @Override
    public boolean isUsuarioValido(String usuario) {
        return false;
    }

    @Override
    public boolean isSenhaValida(String senha) {
        return false;
    }

    @Override
    public void salvarUserToken(UsuarioToken usuarioToken) throws Exception {

    }
}
