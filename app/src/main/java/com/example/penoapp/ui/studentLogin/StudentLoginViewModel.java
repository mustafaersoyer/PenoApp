package com.example.penoapp.ui.studentLogin;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.penoapp.api.RestInterface;
import com.example.penoapp.model.Notice;
import com.example.penoapp.model.Student;
import com.example.penoapp.utils.RetrofitBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentLoginViewModel extends ViewModel {
    private MutableLiveData<List<Student>> noticeList;
    private String no,pass;


    final public LiveData<List<Student>> getAllStudents(String no,String pass) {
        if (noticeList == null) {
            noticeList = new MutableLiveData<>();
            this.no = no;
            this.pass = pass;


            loadNotice(no,pass);
        }
        return noticeList;
    }

    final private void loadNotice(String no,String pass) {
        RetrofitBuilder.retrofitBuild();

        final RestInterface api = RetrofitBuilder.retrofit.create(RestInterface.class);
        Call<List<Student>> call = api.stLogin(Integer.parseInt(no),pass);
        call.enqueue(new Callback<List<Student>>() {
            @Override
            final public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                noticeList.setValue(response.body());
            }

            @Override
            final public void onFailure(Call<List<Student>> call, Throwable t) {
                Log.d("failTag", "fail "+t);
            }
        });
    }
}
