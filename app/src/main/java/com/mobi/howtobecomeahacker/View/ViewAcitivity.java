package com.mobi.howtobecomeahacker.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.mobi.howtobecomeahacker.DateTime.DateTimeActivity;
import com.mobi.howtobecomeahacker.DialogDemo;
import com.mobi.howtobecomeahacker.MainActivity;
import com.mobi.howtobecomeahacker.ProgressBar.ProgressBarActivity;
import com.mobi.howtobecomeahacker.R;
import com.mobi.howtobecomeahacker.View.AutoCompleteTextview.AutoComplete;
import com.mobi.howtobecomeahacker.View.ListView_SpinnerView.ListViewActivity;
import com.mobi.howtobecomeahacker.View.WebView.WebViewDemo;

public class ViewAcitivity extends AppCompatActivity {

    TextView tvListView, tvWeb, tvAuto;
    ImageView imgPlayAuto, imgPlayList, imgPlayWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_acitivity);

        Intent intent = getIntent();
        String date = intent.getStringExtra("Date");
        Toast.makeText(ViewAcitivity.this, "Degsin By Huy Hoàng", Toast.LENGTH_SHORT).show();

        tvAuto = findViewById(R.id.tvAuto);
        tvListView = findViewById(R.id.tvListView);
        tvWeb = findViewById(R.id.tvWeb);

        imgPlayAuto = findViewById(R.id.imgPlayAuto);
        imgPlayList = findViewById(R.id.imgPlayList);
        imgPlayWeb = findViewById(R.id.imgPlayWeb);

        clickListView();
        ClickPlay2();

    }

    protected void clickListView()
    {
        tvAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ViewAcitivity.this,"Auto Complete TextView",Toast.LENGTH_SHORT).show();
            }
        });

        tvListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ViewAcitivity.this,
                        "ListView - SpinerView",Toast.LENGTH_SHORT).show();
            }
        });

        tvWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ViewAcitivity.this,"WebViewDemo",Toast.LENGTH_SHORT).show();
            }
        });

    }

    protected void ClickPlay2()
    {
        imgPlayAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String auto = tvAuto.getText().toString();
                Intent intent = new Intent(ViewAcitivity.this, AutoComplete.class);
                intent.putExtra("Auto",auto);
                startActivity(intent);
            }
        });

        imgPlayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String list = tvListView.getText().toString();
                Intent intent = new Intent(ViewAcitivity.this, ListViewActivity.class);
                intent.putExtra("List",list);
                startActivity(intent);
            }
        });

        imgPlayWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String web = tvWeb.getText().toString();
                Intent intent = new Intent(ViewAcitivity.this, DialogDemo.class);
                intent.putExtra("Web",web);
                startActivity(intent);
            }
        });

    }
}
