package com.example.loadgithubprofilesinarecyclerview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.jetbrains.annotations.NotNull;

import java.net.HttpURLConnection;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentPage extends Fragment {


    private EditText userName;
    private Button btn;
    private RecyclerView recyclerView;
    GitAdapter adapter;
    ArrayList<ResponseDTO> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRecyclerView();
                buildList();


            }
        });

    }

    private void buildList() {

        ApiService apiService = Network.getInstance().create(ApiService.class);
        Call<ArrayList<ResponseDTO>> user = apiService.getData(userName.getText().toString());
        user.enqueue(new Callback<ArrayList<ResponseDTO>>() {
           @Override
           public void onResponse(Call<ArrayList<ResponseDTO>> call, Response<ArrayList<ResponseDTO>> response) {
               if (response.code() == HttpURLConnection.HTTP_OK) {
                   list = response.body();
                   adapter.updateData(list);
               }
           }

           @Override
           public void onFailure(Call<ArrayList<ResponseDTO>> call, Throwable t) {

           }
       });

    }

    private void initView(View view) {
        userName = view.findViewById(R.id.userName);
        btn=view.findViewById(R.id.apiCall);
        recyclerView=view.findViewById(R.id.recyclerView);

    }

    private void setRecyclerView() {
        adapter = new GitAdapter(list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(gridLayoutManager);

    }
}