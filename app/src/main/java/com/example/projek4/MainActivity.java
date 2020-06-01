package com.example.projek4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private  ArrayList<Film> data = new ArrayList<>();
    private RecyclerView recyclerview;
    private RecyclerView.LayoutManager layoutManager;
    String[] judul,desc,genre, durasi, sutradara, tahun;
    TypedArray photo;
    private Toolbar toolbar;

    public void prepare(){
        judul = getResources().getStringArray(R.array.judul);
        desc = getResources().getStringArray(R.array.desc);
        genre = getResources().getStringArray(R.array.genre);
        durasi = getResources().getStringArray(R.array.durasi);
        sutradara = getResources().getStringArray(R.array.sutradara);
        tahun = getResources().getStringArray(R.array.tahun);
        photo = getResources().obtainTypedArray(R.array.photo);
    }

    public void addItem(){
        for (int i=0; i<judul.length; i++){
            Film film = new Film(judul[i],desc[i],genre[i],durasi[i],sutradara[i],tahun[i],photo.getResourceId(i,-1));
            data.add(film);
        }
    }

    public void getData(){
        prepare();
        addItem();
    }

    public void tampilDataGrid(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Movie Catalogue");
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);

        layoutManager = new GridLayoutManager(this, 2);

        recyclerview.setLayoutManager(layoutManager);

        FilmAdapterGrid filmAdaptergrid = new FilmAdapterGrid(this, data);
        recyclerview.setAdapter(filmAdaptergrid);
        recyclerview.setHasFixedSize(true);
        filmAdaptergrid.notifyDataSetChanged();
    }

    public void tampilDataList(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Movie Catalogue");
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);

        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        FilmAdapterList filmAdapterlist = new FilmAdapterList(this, data);
        recyclerview.setAdapter(filmAdapterlist);
        filmAdapterlist.notifyDataSetChanged();
    }

    public void about(){
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Movie Catalogue");
        getData();
        tampilDataList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedmode){
        switch (selectedmode){
            case R.id.list:
                tampilDataList();
                break;
            case R.id.grid:
                tampilDataGrid();
                break;
            case R.id.about:
                about();
                break;
        }
    }
}
