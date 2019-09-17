package com.mobi.howtobecomeahacker.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mobi.howtobecomeahacker.MainActivity;
import com.mobi.howtobecomeahacker.R;

public class ProgressBarActivity extends AppCompatActivity {
    ProgressDialog progressBar;
    Button btnprogressbar;
    private int progressStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        Intent intent = getIntent();
        String date = intent.getStringExtra("Date");
        Toast.makeText(ProgressBarActivity.this, "Degsin By Đức Mạnh", Toast.LENGTH_SHORT).show();

        btnprogressbar = findViewById(R.id.btnProgressBar);

        btnprogressbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Khởi tạo progressBar với đối là Context
                progressBar = new ProgressDialog(ProgressBarActivity.this);
                // Cho phép hủy progressBar nếu ấn nút Back
                progressBar.setCancelable(true);
                // Đặt tiêu đề cho ProgressBar
                progressBar.setMessage("Đang xử lý, vui lòng đợi...");
                // Đặt giao diện cho ProgressBar
                progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                // Đặt giá trị đầu tiên, đây là giá trị thể hiện mức độ hoàn thành công
                // việc có thang từ 0 - > 100
                // do hiện tại công việc chưa hoàn thành được chút nào nên ta đặt là 0
                progressBar.setProgress(0);
                // Đặt cho giá trị lớn nhất thể hiện mức độ hoàn thành công việc là 100
                progressBar.setMax(100);
                // Hiện ProgressBar
                progressBar.show();

                // Tạo một luồng xử lý công việc.
                new MyThread().start();

            }
        });
    }

            class MyThread extends Thread {

                @Override
                public void run() {
                    // xử lý công việc cần hoàn thành
                    while (progressStatus < 100) {
                        progressStatus += 10;
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setProgress(progressStatus);
                                if (progressStatus == 100) {
                                    progressBar.setProgress(progressStatus);
                                    Toast.makeText(ProgressBarActivity.this, "Dowload Complete", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // đóng brogressbar.
                    progressBar.dismiss();
                }
            }

}