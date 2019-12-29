package com.example.penoapp.ui.academicianLogin;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.penoapp.api.RestInterface;
import com.example.penoapp.model.Academician;
import com.example.penoapp.utils.RetrofitBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AcademicianLoginViewModel extends ViewModel {
    private MutableLiveData<List<Academician>> academicianList;

    public LiveData<List<Academician>> getAllAcademician(String no,String pass) {
        if (academicianList == null) {
            academicianList = new MutableLiveData<>();
            loadAcademician(no,pass);
        }
        return academicianList;
    }

    private void loadAcademician(String no,String pass) {
        RetrofitBuilder.retrofitBuild();

        RestInterface api = RetrofitBuilder.retrofit.create(RestInterface.class);
        Call<List<Academician>> call = api.acLogin(Integer.parseInt(no),pass);
        Log.d("nopass",no+" "+pass);
        call.enqueue(new Callback<List<Academician>>() {
            @Override
            public void onResponse(Call<List<Academician>> call, Response<List<Academician>> response) {
                academicianList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Academician>> call, Throwable t) {
                Log.d("failTag", "fail "+t);
            }
        });
    }
}
