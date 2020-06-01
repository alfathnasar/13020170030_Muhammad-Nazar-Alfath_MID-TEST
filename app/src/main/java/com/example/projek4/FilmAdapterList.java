package com.example.projek4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FilmAdapterList extends RecyclerView.Adapter<FilmAdapterList.MyViewHolder> {
    private Context context;
    private ArrayList<Film> data;

    public FilmAdapterList(Context context, ArrayList<Film> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_film, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final Film film = data.get(position);
        holder.judul.setText(film.getJudul());
        holder.desc.setText(film.getDesc());
        holder.photo.setImageResource(film.getPhoto());
        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Details.class);
                intent.putExtra("judul",film.getJudul());
                intent.putExtra("desc",film.getDesc());
                intent.putExtra("photo",film.getPhoto());
                intent.putExtra("genre",film.getGenre());
                intent.putExtra("durasi",film.getDurasi());
                intent.putExtra("sutradara",film.getSutradara());
                intent.putExtra("tahun",film.getTahun());
                v.getContext().startActivities(new Intent[]{intent});
            }
        });
        holder.hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, data.size());

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView judul,desc,genre,durasi,sutradara,tahun;
        private ImageView photo;
        private LinearLayout linear;
        private Button hapus;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.judul);
            desc = itemView.findViewById(R.id.desc);
            photo = itemView.findViewById(R.id.photo);
            genre = itemView.findViewById(R.id.genre);
            durasi = itemView.findViewById(R.id.durasi);
            sutradara = itemView.findViewById(R.id.sutradara);
            tahun = itemView.findViewById(R.id.tahun);
            linear = itemView.findViewById(R.id.linear);
            hapus = itemView.findViewById(R.id.hapus);
        }
    }
}
