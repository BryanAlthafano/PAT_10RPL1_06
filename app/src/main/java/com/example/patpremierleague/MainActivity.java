package com.example.patpremierleague;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<setterGetter> dataClub;
    GridLayoutManager gridLayoutManager;
    clubAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_club);

        addData();
        gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new clubAdapter(dataClub, new clubAdapter.Callback() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MainActivity.this, "Item Clicked", Toast.LENGTH_SHORT).show();
                Intent move = new Intent(getApplicationContext(), detailClub.class);
                setterGetter tampil = dataClub.get(position);
                move.putExtra("name", tampil.getName());
                move.putExtra("description", tampil.getDescription());
                startActivity(move);
            }
        });
        recyclerView.setAdapter(adapter);

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                dataClub.remove(position);
                adapter.notifyDataSetChanged();
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    public void addData() {
        dataClub = new ArrayList<>();
        dataClub.add(new setterGetter("Arsenal", "Arsenal Football Club (dikenal pula sebagai Arsenal atau The Gunners) adalah klub sepak bola profesional Inggris yang berbasis di daerah Holloway, London.", "arsenal"));
        dataClub.add(new setterGetter("Aston Villa", "Aston Villa berdiri tahun 1874 dan menggunakan stadion Villa Park dari tahun 1897 hingga sekarang. Aston Villa merupakan salah satu anggota pendiri Liga Sepak Bola (Football League) dan langsung mencapai kesuksesan, mereka memenangkan lima gelar dalam waktu tujuh musim.", "aston"));
        dataClub.add(new setterGetter("Brighton & Hove Albion", "Brighton & Hove Albion Football Club adalah sebuah klub sepak bola profesional asal Inggris yang berbasis di kota pantai Brighton & Hove, di timur Sussex.", "brighton"));
        dataClub.add(new setterGetter("Burnley", "Burnley Football Club adalah sebuah klub sepak bola Inggris yang bermarkas di Burnley, Lancashire. Klub ini sedang bermain di Liga Utama Inggris, kasta tertinggi sepak bola inggris di musim 2016-17 setelah memenangkan liga peringkat kedua yaitu Liga Championship Inggris di musim sebelumnya.", "burnley"));
        dataClub.add(new setterGetter("Chelsea", "Chelsea Football Club /ˈtʃɛlsiː/ adalah sebuah klub sepak bola Inggris yang bermarkas di Fulham, London. Chelsea didirikan pada tahun 1905 dan kini berkompetisi di Liga Utama Inggris.", "chelsea"));
        dataClub.add(new setterGetter("Crystal Palace", "Crystal Palace Football Club merupakan sebuah tim sepak bola Inggris yang bermarkas di London Borough of Croydon dan didirikan pada tahun 1905.", "crystal"));
        dataClub.add(new setterGetter("Everton", "Everton Football Club /ˈɛvərtən/ adalah sebuah klub sepak bola profesional yang bermarkas di Kota Liverpool, Inggris, dan merupakan klub rival dari klub sekota Liverpool.", "everton"));
        dataClub.add(new setterGetter("Fulham", "Fulham Football Club /ˈfʊləm/ adalah sebuah klub sepak bola Inggris yang didirikan pada tahun 1879. Klub ini bermarkas di daerah Fulham, London dan berkompetisi di Liga Utama Inggris.", "fulham"));
        dataClub.add(new setterGetter("Leeds United", "Leeds United Football Club adalah sebuah klub sepak bola asal Inggris yang berbasis di Beeston, Leeds, West Yorkshire. Pada akhir musim 2019–20, mereka mampu menjadi juara Kejuaraan EFL, sehingga akan promosi ke Liga Utama Inggris pada musim selanjutnya.", "leeds"));
        dataClub.add(new setterGetter("Leicester City", "Leicester City F.C. adalah sebuah tim sepak bola Inggris berbasis di Leicester. Leicester Dikenal juga dengan sebutan The Foxes. Klub ini memainkan pertandingan kandangnya di Stadion King Power yang berkapsitas 32.000 penonton.", "leicester"));
        dataClub.add(new setterGetter("Liverpool", "Liverpool Football Club /ˈlɪvərpuːl/ (dikenal pula sebagai Liverpool atau The Reds) adalah sebuah klub sepak bola asal Inggris yang berbasis di Kota Liverpool.", "liverpool"));
        dataClub.add(new setterGetter("Manchester City", "Manchester City Football Club (dikenal pula sebagai Man City atau The Citizens) adalah sebuah klub sepak bola profesional dari Inggris yang bermain di Liga Premier Inggris. Klub ini merupakaan klub sekota dengan Manchester United dan bermarkas di Stadion Etihad, Manchester.", "mancity"));
        dataClub.add(new setterGetter("Manchester United", "Manchester United Football Club adalah sebuah klub sepak bola profesional Inggris yang berbasis di Old Trafford, Manchester Raya, yang bermain di Liga Inggris. Didirikan sebagai Newton Heath LYR Football Club pada tahun 1878, klub ini berganti nama menjadi Manchester United pada 1902 dan pindah ke Old Trafford pada tahun 1910.", "manutd"));
        dataClub.add(new setterGetter("Newcastle United", "Newcastle United Football Club adalah klub sepak bola profesional Inggris yang berbasis di Newcastle upon Tyne, dan bermain di Liga Utama Inggris, kompetisi tingkat teratas dalam sepak bola Inggris.", "newcastle"));
        dataClub.add(new setterGetter("Sheffield United", "Sheffield United Football Club adalah sebuah tim sepak bola profesional Inggris yang bermarkas di kota Sheffield, Yorkshire Selatan, Inggris. Tim ini dibentuk tahun 1889.", "sheffield"));
        dataClub.add(new setterGetter("Southampton", "Southampton Football Club (berdiri dengan nama St. Mary's YMA) merupakan sebuah tim sepak bola Inggris yang didirikan tahun 1898. Bermarkas di Stadion St Mary's, Southampton, Hampshire, Southampton pada musim 2011-12 bermain di Football League Championship.", "southampton"));
        dataClub.add(new setterGetter("Tottenham Hotspur", "Tottenham Hotspur Football Club /ˈtɒtənəm/, adalah klub sepak bola yang berasal dari Tottenham, sebuah daerah yang berada di wilayah utara London.", "tottenham"));
        dataClub.add(new setterGetter("West Bromwich Albion", "West Bromwich Albion Football Club adalah sebuah klub sepak bola Inggris yang bermarkas di West Bromwich, West Midlands. Didirikan pada tahun 1878.", "wba"));
        dataClub.add(new setterGetter("West Ham United FC", "West Ham United Football Club adalah sebuah klub sepak bola Inggris yang bermarkas di London. Sejak 2016, klub ini memainkan pertandingan kandangnya di London Stadium yang berkapasitas 80.000 kursi.", " westham"));
        dataClub.add(new setterGetter("Wolverhampton Wanderers", "Wolverhampton Wanderers Football Club adalah sebuah klub sepak bola Inggris yang bermarkas di Wolverhampton, Britania Raya yang bermain di Liga Utama Inggris.", "wolverhampton"));
    }

}