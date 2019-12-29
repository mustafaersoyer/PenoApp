package com.example.penoapp.ui.firstScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.penoapp.R;
import com.example.penoapp.ui.academicianLogin.AcademicianLogin;
import com.example.penoapp.ui.studentLogin.StudentLogin;

public class FirstScreen extends AppCompatActivity {
    private Button bt1;
    private Button bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_first);
        bt1=findViewById(R.id.login_aca_button);
        bt2=findViewById(R.id.login_stu_button);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(FirstScreen.this, AcademicianLogin.class);
                startActivity(gecisYap);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap2 = new Intent(FirstScreen.this, StudentLogin.class);
                startActivity(gecisYap2);
            }
        });
    }

}
