package com.mobi.howtobecomeahacker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mobi.howtobecomeahacker.DateTime.DateTimeActivity;
import com.mobi.howtobecomeahacker.View.WebView.WebViewDemo;

public class DialogDemo extends AppCompatActivity {
    Button btnDialog;
    TextView tvHoy01, tvHoy02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_demo);
        btnDialog = findViewById(R.id.btnDialog);
        tvHoy01 = findViewById(R.id.tvHoy01);
        tvHoy02 = findViewById(R.id.tvHoy02);

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alerDialogBuilder = new AlertDialog.Builder(DialogDemo.this);
                //tittle
                alerDialogBuilder.setTitle("Bỏ Đi Mà Làm Người");
                //icon
                alerDialogBuilder.setIcon(R.drawable.stop);
                //mesenger
                alerDialogBuilder.setMessage("Hãy nghĩ về cha mẹ bạn");
                alerDialogBuilder.setCancelable(false);
                alerDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogDemo.this,"Tốt Lắm Bạn hiền",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

                alerDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogDemo.this,"Welcome, Thanh Niên của Năm",Toast.LENGTH_SHORT).show();
                        String hoy = tvHoy01.getText().toString();
                        Intent intent = new Intent(DialogDemo.this, WebViewDemo.class);
                        intent.putExtra("hoy",hoy);
                        startActivity(intent);
                    }
                });

                alerDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogDemo.this,"Hãy Nghĩ Lại Đi",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

                AlertDialog alertDialog = alerDialogBuilder.create();
                alertDialog.show();
            }
        });
    }
}
