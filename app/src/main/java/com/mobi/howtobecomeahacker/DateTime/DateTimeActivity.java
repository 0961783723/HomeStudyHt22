package com.mobi.howtobecomeahacker.DateTime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.mobi.howtobecomeahacker.MainActivity;
import com.mobi.howtobecomeahacker.R;

import java.util.Calendar;

public class DateTimeActivity extends AppCompatActivity {
    private DatePicker datePicker;
    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        Intent intent = getIntent();
        String date = intent.getStringExtra("Date");
        Toast.makeText(DateTimeActivity.this, "Degsin By Đức Khang", Toast.LENGTH_SHORT).show();

        datePicker =findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        setupDatePicker();
        setupTimePicker();
    }

    public void setupDatePicker(){
        Calendar calendar = Calendar.getInstance();
        // Lấy ra năm - tháng - ngày hiện tại
        int year = calendar.get(calendar.YEAR);
        final int month = calendar.get(calendar.MONTH);
        int day = calendar.get(calendar.DAY_OF_MONTH);

        // Khởi tạo sự kiện lắng nghe khi DatePicker thay đổi
        datePicker.init(year,month,day,new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(DateTimeActivity.this, dayOfMonth+"-"+monthOfYear+"-"+year, Toast.LENGTH_SHORT).show();
            }
        });
    }
    // Lắng nghe sự kiện khi TimePicker thay đổi
    public void setupTimePicker(){
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(DateTimeActivity.this, "It's :"+hourOfDay+"h:"+minute+"minutes", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
