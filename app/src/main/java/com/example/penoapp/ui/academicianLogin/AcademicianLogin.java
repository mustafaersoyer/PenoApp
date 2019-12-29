package com.example.penoapp.ui.academicianLogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.penoapp.R;
import com.example.penoapp.model.Academician;
import com.example.penoapp.model.Notice;
import com.example.penoapp.ui.notices.NoticesViewModel;
import com.example.penoapp.ui.sendNotices.SendNotice;
import com.example.penoapp.ui.signUp.SignUp;

import java.util.List;

public class AcademicianLogin extends AppCompatActivity {
    private TextView tx1;
    private TextView acNumber;
    private TextView acPass;
    Button btnAcLogin;
    AcademicianLoginViewModel academicianLoginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_login);
        tx1=findViewById(R.id.txtSignUp);
        btnAcLogin=findViewById(R.id.btnAcLogin);
        acNumber=findViewById(R.id.acNumber);
        acPass=findViewById(R.id.acPass);




        btnAcLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String no = acNumber.getText().toString();
                final String pass = acPass.getText().toString();
                academicianLoginViewModel =
                        ViewModelProviders.of(AcademicianLogin.this).get(AcademicianLoginViewModel.class);
                academicianLoginViewModel.getAllAcademician(no,pass).observe(AcademicianLogin.this, new Observer<List<Academician>>() {
                    @Override
                    public void onChanged(@Nullable List<Academician> academicianList) {
                        if (academicianList.isEmpty()){
                            Toast.makeText(AcademicianLogin.this, ""+no+" asd "+pass, Toast.LENGTH_SHORT).show();
                        }else{

                            Intent i = new Intent(AcademicianLogin.this, SendNotice.class);
                            startActivity(i);
                        }
                    }
                });

            }
        });
        tx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap3 = new Intent(AcademicianLogin.this, SignUp.class);
                startActivity(gecisYap3);
            }
        });
    }
}
