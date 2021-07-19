package com.example.and03unit_2c_2;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<ResponseModel> dataList = new ArrayList<>();
    private Adapter adapter;
    private Button btnGetData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
        setRecyclerView();
        sendData();
//        btnGetData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sendData();
//            }
//        });
    }

    private void sendData() {
        ApiInterface apiInterface = Network.getInstance().create(ApiInterface.class);
        Call<List<ResponseModel>> call = apiInterface.getPost();
        call.enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                // List<ResponseModel> data=response.body();
                //  dataList.add(data);
                dataList = response.body();
                adapter.updateData(dataList);


            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {

            }
        });
    }

    private void setRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new Adapter(dataList);
        recyclerView.setAdapter(adapter);
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        // btnGetData = findViewById(R.id.btnGetData);
    }
}