package com.example.penoapp.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.penoapp.R;

public class loginf extends AppCompatActivity {
    private Button bt1;
    private Button bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginf);
        bt1=(Button)findViewById(R.id.login_aca_button);
        bt2=(Button)findViewById(R.id.login_stu_button);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(loginf.this, StudentLogin.class);
                startActivity(gecisYap);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap2 = new Intent(loginf.this, StudentLogin.class);
                startActivity(gecisYap2);
            }
        });
    }

}
