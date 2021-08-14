package com.example.getlistofalbums;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView ;
    private ArrayList<ResponseDTO> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        buildList();



    }

    private void setRecyclerView(ArrayList<ResponseDTO> list) {
       ListAdapter adapter = new ListAdapter(list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    private void buildList() {
        ProgressDialog progressBar = new ProgressDialog(this);
        progressBar.setMessage("fetching data ...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.show();//displays the progress bar

        ApiService apiService = Network.getRetrofitInstance().create(ApiService.class);
        apiService.getData().enqueue(new Callback<ArrayList<ResponseDTO>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseDTO>> call, Response<ArrayList<ResponseDTO>> response) {
                if(response.body()!=null){
                    list = response.body();
                    setRecyclerView(list);
                    progressBar.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ResponseDTO>> call, Throwable t) {

            }
        });
    }
}