package cat.itb.juegoroom.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cat.itb.juegoroom.R;
import cat.itb.juegoroom.database.Puntuacio;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MostrarPuntuacionViewHolder> {
    private List<Puntuacio> puntuacioList;

    public MyAdapter(List<Puntuacio> puntuacioList) {
        this.puntuacioList = puntuacioList;
    }

    public static class MostrarPuntuacionViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre;
        private TextView puntuacion;

        public MostrarPuntuacionViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre);
            puntuacion = itemView.findViewById(R.id.puntuacion);
        }

        public void bind(Puntuacio puntuacio) {
            nombre.setText(puntuacio.getUser_name());
            String puntos = puntuacio.getPuntuacio() + " puntos";
            puntuacion.setText(puntos);
        }
    }

    @NonNull
    @Override
    public MostrarPuntuacionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new MostrarPuntuacionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MostrarPuntuacionViewHolder holder, int position) {
        Puntuacio puntuacio = puntuacioList.get(position);
        holder.bind(puntuacio);
    }

    @Override
    public int getItemCount() {
        return puntuacioList.size();
    }

}

