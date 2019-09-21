package alvarohnl.eventos.app.login.data;

import alvarohnl.eventos.app.login.data.model.UsuarioRequest;
import alvarohnl.eventos.app.login.data.model.UsuarioToken;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {

    @POST("login")
    Call<UsuarioToken> login(@Body UsuarioRequest userRequest);

}
