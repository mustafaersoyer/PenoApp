package com.example.penoapp.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.penoapp.R;
import com.example.penoapp.adapter.NoticeAdapter;
import com.example.penoapp.model.Notice;

import java.util.List;

public class MainFragment extends Fragment implements NoticeAdapter.ItemClickListener {

    private MainViewModel mViewModel;
    RecyclerView recyclerView;
    NoticeAdapter noticeAdapter;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.main_fragment, container, false);
        mViewModel =
                ViewModelProviders.of(this).get(MainViewModel.class);

        recyclerView = root.findViewById(R.id.rvNotices);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        noticeAdapter = new NoticeAdapter(getContext());
        recyclerView.setAdapter(noticeAdapter);
        noticeAdapter.setClickListener(this);

        mViewModel.getAllNotice().observe(this, new Observer<List<Notice>>() {
            @Override
            public void onChanged(@Nullable List<Notice> noticeList) {
                noticeAdapter.setItems(noticeList);
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onItemClick(LinearLayout layout) {
       /* if(openClose){
            layout.setVisibility(View.VISIBLE);
            openClose = false;
        }else{
            layout.setVisibility(View.GONE);
            openClose = true;
        }*/
    }//Detaylar kısmı

}
