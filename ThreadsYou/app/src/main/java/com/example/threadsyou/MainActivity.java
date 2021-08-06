package com.example.threadsyou;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnStartProgress;
    ProgressDialog progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStartProgress = findViewById(R.id.button1);





        btnStartProgress.setOnClickListener(new View.OnClickListener(){
            Handler   handler = new Handler(Looper.getMainLooper()){
                @Override
                public void handleMessage(@NonNull Message msg) {
                    super.handleMessage(msg);

                    progressBar.setProgress((Integer) msg.obj);
                    if((int)msg.obj==100){
                        progressBar.dismiss();
                    }
                }
            };

            @Override
            public void onClick(View v) {
                WorkerThread progressBarHandler = new WorkerThread("async",handler);
                progressBarHandler.start();

                progressBar = new ProgressDialog(MainActivity.this);
                progressBar.setCancelable(true);
                progressBar.setMessage("File downloading ...");
                progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressBar.setProgress(0);
                progressBar.setMax(100);
                progressBar.show();
            }

        });
    }
}
