package com.example.patpremierleague;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class detailClub extends AppCompatActivity {

    TextView nameDetail;
    TextView descriptionDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_club);

        nameDetail = (TextView) findViewById(R.id.nameDetail);
        descriptionDetail = (TextView) findViewById(R.id.descriptionDetail);

        nameDetail.setText(getIntent().getStringExtra("name"));
        descriptionDetail.setText(getIntent().getStringExtra("description"));

    }


}