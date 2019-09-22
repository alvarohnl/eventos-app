package alvarohnl.eventos.app.eventos.presenter;

import java.util.List;

import alvarohnl.eventos.app.eventos.data.model.Evento;
import alvarohnl.eventos.app.eventos.view.EventosActivity;

public interface EventosContract {

    interface View {

        public void exibirEventos(List<Evento> eventos);

    }

    interface Presenter {

        public void setView(EventosActivity eventosActivity);

        public void carregarEventos();

    }

}
