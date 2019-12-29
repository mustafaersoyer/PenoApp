package com.example.penoapp.ui.sendNotices;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.penoapp.api.RestInterface;
import com.example.penoapp.model.Lecture;
import com.example.penoapp.model.Notice;
import com.example.penoapp.utils.RetrofitBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SendNoticeViewModel extends ViewModel {
    private MutableLiveData<List<Notice>> noticeList;
    private MutableLiveData<List<Lecture>> lectureList;

    final public LiveData<List<Notice>> sendNotices() {
        if (noticeList == null) {
            noticeList = new MutableLiveData<>();
            sendNotice();
        }
        return noticeList;
    }

    final private void sendNotice() {
        RetrofitBuilder.retrofitBuild();

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


    final public LiveData<List<Lecture>> getLectures() {
        if (lectureList == null) {
            lectureList = new MutableLiveData<>();
            loadLecture();
        }
        return lectureList;
    }


    final private void loadLecture() {
        RetrofitBuilder.retrofitBuild();

        final RestInterface api = RetrofitBuilder.retrofit.create(RestInterface.class);
        Call<List<Lecture>> call = api.getAllLecture();
        call.enqueue(new Callback<List<Lecture>>() {
            @Override
            final public void onResponse(Call<List<Lecture>> call, Response<List<Lecture>> response) {
                lectureList.setValue(response.body());
            }

            @Override
            final public void onFailure(Call<List<Lecture>> call, Throwable t) {
                Log.d("failTag", "fail "+t);
            }
        });
    }

}
