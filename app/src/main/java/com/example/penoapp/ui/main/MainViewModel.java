package com.example.penoapp.ui.main;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.penoapp.model.Notice;
import com.example.penoapp.api.RestInterface;
import com.example.penoapp.utils.RetrofitBuilder;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    private MutableLiveData<List<Notice>> noticeList;

    final public LiveData<List<Notice>> getAllNotice() {
        if (noticeList == null) {
            noticeList = new MutableLiveData<>();
            loadNotice();
        }
        return noticeList;
    }

    final private void loadNotice() {
        RetrofitBuilder.retrofitBuild();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", "8962c635-d42d-43c5-b1e3-fc77fcf71b19");

        final RestInterface api = RetrofitBuilder.retrofit.create(RestInterface.class);
        Call<List<Notice>> call = api.getAllNotice();
        call.enqueue(new Callback<List<Notice>>() {
            @Override
            final public void onResponse(Call<List<Notice>> call, Response<List<Notice>> response) {
                noticeList.setValue(response.body());
            }

            @Override
            final public void onFailure(Call<List<Notice>> call, Throwable t) {
                Log.d("failTag", "fail "+t);
            }
        });
    }
}
