package com.example.penoapp.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.penoapp.R;
import com.example.penoapp.sign;

public class StudentLogin extends AppCompatActivity {
    private TextView tx1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login2);
        tx1=(TextView)findViewById(R.id.textView2);
        tx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap3 = new Intent(StudentLogin.this, sign.class);
                startActivity(gecisYap3);
            }
        });
    }
}
