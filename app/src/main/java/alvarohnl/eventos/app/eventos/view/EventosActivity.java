package alvarohnl.eventos.app.eventos.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import alvarohnl.eventos.app.R;
import alvarohnl.eventos.app.eventos.data.model.Evento;
import alvarohnl.eventos.app.eventos.presenter.EventosContract;
import alvarohnl.eventos.app.eventos.presenter.EventosPresenter;

public class EventosActivity extends AppCompatActivity implements EventosContract.View {

    private EventosContract.Presenter mPresenter;
    private RecyclerView recylerEvents;
    private EventoAdapter eventAdapter;

    private List<Evento> eventos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
        initComponents();

        mPresenter = new EventosPresenter();
        mPresenter.setView(this);

        recylerEvents.setLayoutManager(new LinearLayoutManager(this));
        recylerEvents.setHasFixedSize(true);
        eventAdapter = new EventoAdapter(eventos, this);
        recylerEvents.setAdapter(eventAdapter);
        mPresenter.carregarEventos();

    }

    @Override
    public void exibirEventos(List<Evento> eventos) {

        this.eventos.addAll(eventos);
        eventAdapter.notifyDataSetChanged();

    }

    private void initComponents() {

        recylerEvents = findViewById(R.id.recyclerEvents);

    }

}
