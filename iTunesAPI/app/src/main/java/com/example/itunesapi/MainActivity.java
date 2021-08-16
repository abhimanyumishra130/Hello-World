package com.example.itunesapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    private RecyclerView recyclerView;
    ArrayList<ResultsDTO> list;
    private Button btn;
    private EditText term;
    private ResponseDTO resultsDTO;

    private ItemAdapter adapter;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                list = new ArrayList<>();
                buildList();
                setRecyclerView();
            }
        });

    }

    private void buildList() {

        ApiService apiService = NetWork.getInstance().create(ApiService.class);
        Call<ResponseDTO> user =apiService.getSong(term.getText().toString());
       user.enqueue(new Callback<ResponseDTO>() {
           @Override
           public void onResponse(Call<ResponseDTO> call, Response<ResponseDTO> response) {
               if(response.body()!=null){
                   resultsDTO = response.body();
                   list.addAll(resultsDTO.getResults());
                   adapter.update(list);


               }

           }

           @Override
           public void onFailure(Call<ResponseDTO> call, Throwable t) {

           }
       });
    }

    private void setRecyclerView() {
        adapter = new ItemAdapter(list,this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setAdapter(adapter);;
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        btn = findViewById(R.id.search);
        term = findViewById(R.id.searchArtistName);
    }

    @Override
    public void onClicked(ResultsDTO resultsDTO, int position) {


    }
}