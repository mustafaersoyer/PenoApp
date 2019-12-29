package com.example.penoapp.ui.sendNotices;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.penoapp.R;
import com.example.penoapp.model.Academician;
import com.example.penoapp.model.Lecture;
import com.example.penoapp.ui.academicianLogin.AcademicianLogin;
import com.example.penoapp.ui.academicianLogin.AcademicianLoginViewModel;

import java.util.ArrayList;
import java.util.List;


public class SendNotice extends AppCompatActivity {


    SendNoticeViewModel sendNoticeViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticeput);
        String[] country = { "Ankara", "İstanbul", "Tunceli", "İzmir", "Tokat",  };
        final Spinner spin = findViewById(R.id.spinner1);
       // spin.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        //Creating the ArrayAdapter instance having the country list
       final ArrayList<String> arrayList = new ArrayList<>();

        sendNoticeViewModel =
                ViewModelProviders.of(SendNotice.this).get(SendNoticeViewModel.class);
        sendNoticeViewModel.getLectures().observe(SendNotice.this, new Observer<List<Lecture>>() {
            @Override
            public void onChanged(@Nullable List<Lecture> lectureList) {
                Lecture lecture;
                for (int i=0; i<lectureList.size();i++) {
                    lecture = lectureList.get(i);
                    arrayList.add(lecture.getName());
                }

                ArrayAdapter<String> dataAdapter = new ArrayAdapter(SendNotice.this,
                        android.R.layout.simple_spinner_item, arrayList);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spin.setAdapter(dataAdapter);
            }
        });
    }
}
