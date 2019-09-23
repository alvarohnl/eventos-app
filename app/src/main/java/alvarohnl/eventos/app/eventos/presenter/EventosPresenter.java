package alvarohnl.eventos.app.eventos.presenter;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import alvarohnl.eventos.app.config.RetrofitClient;
import alvarohnl.eventos.app.eventos.data.EventoService;
import alvarohnl.eventos.app.eventos.data.model.Evento;
import alvarohnl.eventos.app.eventos.data.model.EventoResponse;
import alvarohnl.eventos.app.eventos.view.EventosActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventosPresenter implements EventosContract.Presenter {

    private EventosContract.View view;

    @Override
    public void setView(EventosActivity eventosActivity) {
        view = eventosActivity;
    }

    @Override
    public void carregarEventos() {

        EventoService service = RetrofitClient.getRetrofitInstance().create(EventoService.class);
        List<Evento> eventos = new ArrayList<>();

        Call<EventoResponse> call = service.buscarEventos();

        call.enqueue(new Callback<EventoResponse>() {
            @Override
            public void onResponse(Call<EventoResponse> call, Response<EventoResponse> response) {

                if (response.isSuccessful()) {

                    EventoResponse evento = response.body();
                    List<Evento> eventos = evento.getEventos();
                    Collections.sort(eventos);

                    view.exibirEventos(eventos);

                }

            }

            @Override
            public void onFailure(Call<EventoResponse> call, Throwable t) {
                Log.e("E", t.getLocalizedMessage(), t);
            }

        });
    }

}
