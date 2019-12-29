package com.example.penoapp.ui.studentLogin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.penoapp.MainActivity;
import com.example.penoapp.R;
import com.example.penoapp.model.Academician;
import com.example.penoapp.model.Student;
import com.example.penoapp.ui.academicianLogin.AcademicianLogin;
import com.example.penoapp.ui.academicianLogin.AcademicianLoginViewModel;
import com.example.penoapp.ui.notices.NoticesFragment;
import com.example.penoapp.ui.sendNotices.SendNotice;
import com.example.penoapp.ui.signUp.SignUp;

import java.util.List;

public class StudentLogin extends AppCompatActivity {
    private TextView tx1;
    Button btnLogin;
    private TextView stNumber;
    private TextView stPass;
    StudentLoginViewModel studentLoginViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login2);
        tx1=findViewById(R.id.textView2);
        stNumber=findViewById(R.id.stNo);
        stPass=findViewById(R.id.stPass);
        btnLogin=findViewById(R.id.btnStudentLogin);

        studentLoginViewModel =
                ViewModelProviders.of(StudentLogin.this).get(StudentLoginViewModel.class);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                final String no = stNumber.getText().toString();
                final String pass = stPass.getText().toString();
                studentLoginViewModel.getAllStudents(no,pass).observe(StudentLogin.this, new Observer<List<Student>>() {
                    @Override
                    public void onChanged(@Nullable List<Student> studentList) {
                        if (studentList.isEmpty()){
                            Toast.makeText(StudentLogin.this, ""+no+" asd "+pass, Toast.LENGTH_SHORT).show();
                        }else{

                            Intent i = new Intent(StudentLogin.this, MainActivity.class);
                            startActivity(i);
                        }
                    }
                });

                Intent i = new Intent(StudentLogin.this, MainActivity.class);
                startActivity(i);
            }
        });
        tx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap3 = new Intent(StudentLogin.this, SignUp.class);
                startActivity(gecisYap3);
            }
        });
    }
}
