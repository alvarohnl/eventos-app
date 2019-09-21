package alvarohnl.eventos.app.login.presenter;

import android.util.Log;

import alvarohnl.eventos.app.config.RetrofitClient;
import alvarohnl.eventos.app.login.business.UsuarioBusiness;
import alvarohnl.eventos.app.login.business.UsuarioBusinessImpl;
import alvarohnl.eventos.app.login.data.LoginService;
import alvarohnl.eventos.app.login.data.model.UsuarioRequest;
import alvarohnl.eventos.app.login.data.model.UsuarioToken;
import alvarohnl.eventos.app.login.view.LoginActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private UsuarioBusiness userBusiness;

    public LoginPresenter() {
        userBusiness = new UsuarioBusinessImpl();
    }

    @Override
    public void setView(LoginActivity loginActivity) {
        view = loginActivity;
    }

    @Override
    public void login(final String usuario, String senha) {
        LoginService service = RetrofitClient.getRetrofitInstance().create(LoginService.class);

        UsuarioRequest usuarioRequest = new UsuarioRequest(usuario, senha);
        Call<UsuarioToken> call = service.login(usuarioRequest);

        call.enqueue(new Callback<UsuarioToken>() {
            @Override
            public void onResponse(Call<UsuarioToken> call, Response<UsuarioToken> response) {

                if (response.isSuccessful()) {

                    UsuarioToken usuarioToken = response.body();
                    userBusiness.salvarUserToken(usuarioToken);
                    view.loginSucesso(usuarioToken);

                }

            }

            @Override
            public void onFailure(Call<UsuarioToken> call, Throwable t) {
                Log.e("E", t.getLocalizedMessage(), t);
            }
        });

    }

}
