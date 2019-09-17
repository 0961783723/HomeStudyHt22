package com.mobi.howtobecomeahacker.View.AutoCompleteTextview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import com.mobi.howtobecomeahacker.R;

public class AutoComplete extends AppCompatActivity {
    EditText textFullname;
    AutoCompleteTextView textCountry;
    MultiAutoCompleteTextView textProgrammingLanguage;

    Button buttonSubmit;

    private String[] countries = {"Vietnam", "England", "Canada", "France", "Australia"};

    private String[] languages = {"Java ", "CSharp", "Visual Basic", "Swift", "C/C++"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);

        Intent intent = getIntent();
        String auto = intent.getStringExtra("Auto");

        textFullname = findViewById(R.id.editText);
        textCountry =findViewById(R.id.autoCompleteTextView);
        textProgrammingLanguage = findViewById(R.id.multiAutoCompleteTextView);
        buttonSubmit= findViewById(R.id.button);

        ArrayAdapter adapterCountries = new ArrayAdapter(this,android.R.layout.simple_list_item_1,countries);

        textCountry.setAdapter(adapterCountries);


        // Sét đặt số ký tự nhỏ nhất, để cửa sổ gợi ý hiển thị
        textCountry.setThreshold(1);

        ArrayAdapter adapterLanguages = new ArrayAdapter(this,android.R.layout.simple_list_item_1,languages);

        textProgrammingLanguage.setAdapter(adapterLanguages);

        textProgrammingLanguage.setThreshold(1);


        // Các đoạn text ngăn cách nhau bởi dấu phẩy.
        textProgrammingLanguage.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        buttonSubmit.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }

    private void submitForm(){
        String text="Fullname: "+ this.textFullname.getText().toString()
                +"\nCountry: "+ this.textCountry.getText().toString()
                +"\nLanguages: "+ this.textProgrammingLanguage.getText().toString();

        Toast.makeText(this, text,Toast.LENGTH_LONG).show();

    }
    }
