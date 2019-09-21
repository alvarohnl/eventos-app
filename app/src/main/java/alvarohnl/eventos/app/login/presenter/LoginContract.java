package alvarohnl.eventos.app.login.presenter;

import alvarohnl.eventos.app.login.data.model.UsuarioToken;
import alvarohnl.eventos.app.login.view.LoginActivity;

public interface LoginContract {

    interface View {

        public void loginSucesso(UsuarioToken usuarioToken);

    }

    interface Presenter {

        public void setView(LoginActivity loginActivity);

        public void login(String usuario, String senha);

    }

}
