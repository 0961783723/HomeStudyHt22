package com.mobi.howtobecomeahacker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mobi.howtobecomeahacker.DateTime.DateTimeActivity;
import com.mobi.howtobecomeahacker.ProgressBar.ProgressBarActivity;
import com.mobi.howtobecomeahacker.View.ViewAcitivity;

public class MainActivity extends AppCompatActivity {
    TextView tvView, tvPro, tvDate;
    ImageView imgPlayView, imgPlayPro, imgPlayDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDate = findViewById(R.id.tvDate);
        tvPro = findViewById(R.id.tvPro);
        tvView = findViewById(R.id.tvView);

        imgPlayDate = findViewById(R.id.imgPlay01);
        imgPlayView = findViewById(R.id.imgPlay02);
        imgPlayPro = findViewById(R.id.imgPlay03);

        Toast.makeText(MainActivity.this, "Degsin By Đức Khang", Toast.LENGTH_SHORT).show();

        clickView();
        ClickPlay();

    }


    protected void clickView()
    {
        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Time/DatePicker",Toast.LENGTH_SHORT).show();
            }
        });

        tvView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,
                        "WebViewDemo,Auto Complete TextView, ListView, SpinerView",Toast.LENGTH_SHORT).show();
            }
        });

        tvPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"ProgressBar",Toast.LENGTH_SHORT).show();
            }
        });

    }

    protected void ClickPlay()
    {
        imgPlayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Date = tvDate.getText().toString();
                Intent intent = new Intent(MainActivity.this, DateTimeActivity.class);
                intent.putExtra("Date",Date);
                startActivity(intent);
            }
        });

        imgPlayView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Date = tvDate.getText().toString();
                Intent intent = new Intent(MainActivity.this, ViewAcitivity.class);
                intent.putExtra("Date",Date);
                startActivity(intent);
            }
        });

        imgPlayPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Date = tvDate.getText().toString();
                Intent intent = new Intent(MainActivity.this, ProgressBarActivity.class);
                intent.putExtra("Date",Date);
                startActivity(intent);
            }
        });

    }
}
