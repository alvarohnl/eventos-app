package alvarohnl.eventos.app.eventos.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import alvarohnl.eventos.app.R;
import alvarohnl.eventos.app.Util.DateUtil;
import alvarohnl.eventos.app.eventos.data.model.Evento;

public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.MyViewHolder> {

    private List<Evento> events;
    private Context contex;

    public EventoAdapter(List<Evento> events, Context contex) {
        this.events = events;
        this.contex = contex;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_evento, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Evento evento = events.get(position);
        holder.getTitulo().setText(evento.getNome());
        holder.getDescricao().setText(evento.getDescricao());
        holder.getData().setText(DateUtil.formatFromLong(evento.getData()));

        String placeholderUri = "drawable://" + R.drawable.placeholder;

        Picasso.get()
                .load(TextUtils.isEmpty(evento.getRotaImagem()) ? placeholderUri : evento.getRotaImagem())
                .placeholder(R.drawable.placeholder)
                .fit()
                .centerInside()
                .into(holder.foto);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        TextView descricao;
        TextView data;
        ImageView foto;


        public MyViewHolder(View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textTitulo);
            descricao = itemView.findViewById(R.id.textDescricao);
            data = itemView.findViewById(R.id.textData);
            foto = itemView.findViewById(R.id.imageEvento);

        }

        public TextView getTitulo() {
            return titulo;
        }

        public void setTitulo(TextView titulo) {
            this.titulo = titulo;
        }

        public TextView getDescricao() {
            return descricao;
        }

        public void setDescricao(TextView descricao) {
            this.descricao = descricao;
        }

        public TextView getData() {
            return data;
        }

        public void setData(TextView data) {
            this.data = data;
        }

        public ImageView getFoto() {
            return foto;
        }

        public void setFoto(ImageView foto) {
            this.foto = foto;
        }

    }

}
