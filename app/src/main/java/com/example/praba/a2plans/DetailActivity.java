package com.example.praba.a2plans;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    ImageView imgGambar;
    TextView txtDet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //pemanggilan ID dari layout activity_detail.xml
        imgGambar = findViewById(R.id.imgDet);
        txtDet = findViewById(R.id.txtDetail);

        // intent ini fungsinya adalah untuk menerima data dari HomeAdapter
        Intent terimadata = getIntent();
        String nm = terimadata.getStringExtra("Nama");
        getSupportActionBar().setTitle(nm);

        imgGambar.setImageResource(terimadata.getIntExtra("img", 1));
        txtDet.setText(terimadata.getStringExtra("Detail"));

    }
}
