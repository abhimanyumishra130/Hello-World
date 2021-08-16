package com.example.getresourcesapi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondPage extends AppCompatActivity {

    private TextView name, company, year;
    LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        initView();
        Intent intent = getIntent();
        String str = intent.getStringExtra("data");


        ProgressDialog progressBar = new ProgressDialog(this);
        progressBar.setMessage("File downloading ...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.show();//displays the progress bar


        ApiService apiService =Network.getInstance().create(ApiService.class);
        Call<ResponseDTO> user = apiService.getData(Integer.parseInt(str));
        user.enqueue(new Callback<ResponseDTO>() {
            @Override
            public void onResponse(Call<ResponseDTO> call, Response<ResponseDTO> response) {
                if(response.body()!=null){
                    name.setText(response.body().getData().getName());
                    company.setText(response.body().getData().getPantoneValue());
                    year.setText(response.body().getData().getYear()+"");
                    linearLayout.setBackgroundColor(Color.parseColor(response.body().getData().getColor()+""));
                    progressBar.dismiss();

                }
            }

            @Override
            public void onFailure(Call<ResponseDTO> call, Throwable t) {

            }
        });

    }

    private void setData(String str) {


    }

    private void initView() {
        name = findViewById(R.id.nameId);
        company = findViewById(R.id.companyName);
        year = findViewById(R.id.yearName);
        linearLayout = findViewById(R.id.linearLayout);
    }
}