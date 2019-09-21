package alvarohnl.eventos.app.login.presenter;

import android.util.Log;

import alvarohnl.eventos.app.config.RetrofitClient;
import alvarohnl.eventos.app.login.data.LoginService;
import alvarohnl.eventos.app.login.data.model.UsuarioRequest;
import alvarohnl.eventos.app.login.data.model.UsuarioToken;
import alvarohnl.eventos.app.login.view.LoginActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;

    @Override
    public void setView(LoginActivity loginActivity) {
        view = loginActivity;
    }

    @Override
    public void login(String usuario, String senha) {

        LoginService service = RetrofitClient.getRetrofitInstance().create(LoginService.class);

        UsuarioRequest usuarioRequest = new UsuarioRequest(usuario, senha);
        Call<UsuarioToken> call = service.login(usuarioRequest);

        call.enqueue(new Callback<UsuarioToken>() {
            @Override
            public void onResponse(Call<UsuarioToken> call, Response<UsuarioToken> response) {

                UsuarioToken userToken = response.body();

                if (response.isSuccessful()) {
                    view.loginSucesso(userToken);
                }

            }

            @Override
            public void onFailure(Call<UsuarioToken> call, Throwable t) {
                System.out.println(t.getLocalizedMessage());
            }
        });

    }

}
