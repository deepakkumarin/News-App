package com.deepakkumarinc.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.deepakkumarinc.newsapp.Adapters.Adapter;
import com.deepakkumarinc.newsapp.Models.MainNews;
import com.deepakkumarinc.newsapp.Models.ModelClass;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {


    String api = "a0bb2861e2de4550803fe17a1ab94bd8";
    ArrayList<ModelClass> modelList1;
    Adapter adapter;
    String country="in";
    private RecyclerView recyclerViewOfHome;

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.homefragment,null);

        recyclerViewOfHome = v.findViewById(R.id.recyclerViewOfHome);
        modelList1 = new ArrayList<>();
        recyclerViewOfHome.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(),modelList1);
        recyclerViewOfHome.setAdapter(adapter);

        findNews();
        

        return v;
    }

    private void findNews() {

        ApiUtilities.getApiInterface().getNews(country,100,api).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if (response.isSuccessful())
                {
                    modelList1.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });



    }
}
