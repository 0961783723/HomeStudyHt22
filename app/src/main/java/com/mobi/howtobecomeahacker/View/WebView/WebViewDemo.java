package com.mobi.howtobecomeahacker.View.WebView;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.mobi.howtobecomeahacker.MainActivity;
import com.mobi.howtobecomeahacker.R;

public class WebViewDemo extends AppCompatActivity {
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        Intent intent = getIntent();
        String Hoy = intent.getStringExtra("hoy");
        Toast.makeText(WebViewDemo.this, "Degsin By Viết Hà", Toast.LENGTH_SHORT).show();

        webView = findViewById(R.id.containerWebView);

        checkInternetConnection();

        webView.setWebViewClient(new MyWebView());
        String url = "https://fr.pornhub.com";
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);



    }

    private class MyWebView extends WebViewClient{
        public boolean shouldOverrideUrlLoading(WebView view,String url)
        {
            view.loadUrl(url);
            return true;
        }
    }


    private boolean checkInternetConnection() {

        ConnectivityManager connManager =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);


        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();

        if (networkInfo == null) {
            Toast.makeText(this, "Đăng Ký Mạng Đi Bạn Nhé", Toast.LENGTH_LONG).show();
            return false;
        }

        if (!networkInfo.isConnected()) {
            Toast.makeText(this, "Có mạng rồi, đừng xem vớ vẩn nhé ^^", Toast.LENGTH_LONG).show();
            return false;
        }

        if (!networkInfo.isAvailable()) {
            Toast.makeText(this, "Đăng Ký Mạng Đi Bạn Nhé", Toast.LENGTH_LONG).show();
            return false;
        }
        Toast.makeText(this, "Có mạng rồi, đừng xem vớ vẩn nhé ^^", Toast.LENGTH_LONG).show();
        return true;
    }

}
