package com.example.penoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Noticeput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticeput);
        String[] country = { "Ankara", "İstanbul", "Tunceli", "İzmir", "Tokat",  };
        Spinner spin = (Spinner) findViewById(R.id.spinner1);
        spin.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
    }
}
