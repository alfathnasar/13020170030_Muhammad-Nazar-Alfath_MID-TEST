package com.example.projek4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Details extends AppCompatActivity {
    private TextView judul,desc,genre,durasi,sutradara,tahun;
    private ImageView photo;
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    String getjudul,getdesc,getgenre,getdurasi,getsutradara,gettahun;
    int getphoto;
    String[] nama;
    TypedArray photocast;
    private ArrayList<FilmDetails> data = new ArrayList<>();

    public void prepare(){
        switch (getjudul){
            case "Iron Man":
                nama = getResources().getStringArray(R.array.ironman);
                photocast = getResources().obtainTypedArray(R.array.castironman);
                break;
            case "The Incredible Hulk":
                nama = getResources().getStringArray(R.array.hulk);
                photocast = getResources().obtainTypedArray(R.array.casthulk);
                break;
            case "Iron Man 2":
                nama = getResources().getStringArray(R.array.ironman2);
                photocast = getResources().obtainTypedArray(R.array.castironman2);
                break;
            case "Thor":
                nama = getResources().getStringArray(R.array.thor);
                photocast = getResources().obtainTypedArray(R.array.castthor);
                break;
            case "Captain America: The First Avenger":
                nama = getResources().getStringArray(R.array.captain1);
                photocast = getResources().obtainTypedArray(R.array.castcaptain1);
                break;
            case "The Avenger":
                nama = getResources().getStringArray(R.array.avengers1);
                photocast = getResources().obtainTypedArray(R.array.castavenger1);
                break;
            case "Iron Man 3":
                nama = getResources().getStringArray(R.array.ironman3);
                photocast = getResources().obtainTypedArray(R.array.castironman3);
                break;
            case "Thor: The Dark World":
                nama = getResources().getStringArray(R.array.thor2);
                photocast = getResources().obtainTypedArray(R.array.castthor2);
                break;
            case "Captain America: The Winter Soldier":
                nama = getResources().getStringArray(R.array.captain2);
                photocast = getResources().obtainTypedArray(R.array.castcaptain2);
                break;
            case "Guardians Of The Galaxy":
                nama = getResources().getStringArray(R.array.gotg);
                photocast = getResources().obtainTypedArray(R.array.castgotg);
                break;
            case "Avengers: Age Of Ultron":
                nama = getResources().getStringArray(R.array.avengers2);
                photocast = getResources().obtainTypedArray(R.array.castavenger2);
                break;
            case "Ant-Man":
                nama = getResources().getStringArray(R.array.antman);
                photocast = getResources().obtainTypedArray(R.array.castantman);
                break;
            case "Captain America: Civil War":
                nama = getResources().getStringArray(R.array.captain3);
                photocast = getResources().obtainTypedArray(R.array.castcaptain3);
                break;
            case "Doctor Strange":
                nama = getResources().getStringArray(R.array.doctorstrange);
                photocast = getResources().obtainTypedArray(R.array.castdoctorstrange);
                break;
            case "Guardians Of The Galaxy Vol.2":
                nama = getResources().getStringArray(R.array.gotg2);
                photocast = getResources().obtainTypedArray(R.array.castgotg2);
                break;
            case "Spider-Man: Homecoming":
                nama = getResources().getStringArray(R.array.spiderman);
                photocast = getResources().obtainTypedArray(R.array.castspiderman);
                break;
            case "Thor: Ragnarok":
                nama = getResources().getStringArray(R.array.thor3);
                photocast = getResources().obtainTypedArray(R.array.castthor3);
                break;
            case "Black Panther":
                nama = getResources().getStringArray(R.array.blackpanther);
                photocast = getResources().obtainTypedArray(R.array.castblackpanther);
                break;
            case "Avengers: Infinity War":
                nama = getResources().getStringArray(R.array.avenger3);
                photocast = getResources().obtainTypedArray(R.array.castavenger3);
                break;
            case "Ant-Man and the Wasp":
                nama = getResources().getStringArray(R.array.antman2);
                photocast = getResources().obtainTypedArray(R.array.castantman2);
                break;
            case "Captain Marvel":
                nama = getResources().getStringArray(R.array.captainmarvel);
                photocast = getResources().obtainTypedArray(R.array.castcaptainmarvel);
                break;
            case "Avenger: Endgame":
                nama = getResources().getStringArray(R.array.avenger4);
                photocast = getResources().obtainTypedArray(R.array.castavenger4);
                break;
            case "Spider-Man: Far From Home":
                nama = getResources().getStringArray(R.array.spiderman2);
                photocast = getResources().obtainTypedArray(R.array.castspiderman2);
                break;
        }
    }

    public void addItem(){
        for (int i=0;i<nama.length;i++){
            FilmDetails film = new FilmDetails(nama[i],photocast.getResourceId(i,-1));
            data.add(film);
        }
    }

    public void getData(){
        prepare();
        addItem();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        recyclerView = findViewById(R.id.cast);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        FilmAdapterDetails filmAdapterDetails = new FilmAdapterDetails(this, data);
        recyclerView.setAdapter(filmAdapterDetails);
        filmAdapterDetails.notifyDataSetChanged();

        toolbar = findViewById(R.id.toolbar);
        judul = findViewById(R.id.judul);
        desc = findViewById(R.id.desc);
        genre = findViewById(R.id.genre);
        durasi = findViewById(R.id.durasi);
        sutradara = findViewById(R.id.sutradara);
        tahun = findViewById(R.id.tahun);
        photo = findViewById(R.id.photo);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getjudul = getIntent().getStringExtra("judul");
        getdesc = getIntent().getStringExtra("desc");
        getgenre = getIntent().getStringExtra("genre");
        getdurasi = getIntent().getStringExtra("durasi");
        getsutradara = getIntent().getStringExtra("sutradara");
        gettahun = getIntent().getStringExtra("tahun");
        getphoto = getIntent().getIntExtra("photo",0);

        getData();

        judul.setText(getjudul);
        desc.setText(getdesc);
        genre.setText(getgenre);
        durasi.setText(getdurasi);
        sutradara.setText(getsutradara);
        tahun.setText(gettahun);
        photo.setImageResource(getphoto);

    }
}
