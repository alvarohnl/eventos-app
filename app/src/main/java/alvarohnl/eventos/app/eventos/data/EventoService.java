package alvarohnl.eventos.app.eventos.data;

import alvarohnl.eventos.app.eventos.data.model.EventoResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface EventoService {

    @GET("eventos-mensais")
    Call<EventoResponse> buscarEventos();

}
