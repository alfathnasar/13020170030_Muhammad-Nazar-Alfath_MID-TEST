package com.example.projek4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FilmAdapterDetails extends RecyclerView.Adapter<FilmAdapterDetails.MyViewHolder>{
    private Context context;
    private ArrayList<FilmDetails> data;

    public FilmAdapterDetails(Context context, ArrayList<FilmDetails> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cast, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        FilmDetails film = data.get(position);
        holder.photocast.setImageResource(film.getPhotocast());
        holder.nama.setText(film.getNama());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView photocast;
        private TextView nama;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            photocast = itemView.findViewById(R.id.photocast);
            nama = itemView.findViewById(R.id.nama);
        }
    }
}
