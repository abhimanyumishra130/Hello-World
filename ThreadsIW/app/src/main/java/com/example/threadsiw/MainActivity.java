package com.example.threadsiw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button task1, task2;
    public  static  final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        task1 = findViewById(R.id.btn1);
        task2 = findViewById(R.id.btn2);

        WorkerThread workerThread = new WorkerThread();
        workerThread.start();
        task1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                workerThread.addTaskToMessageQueue(taskOne);

            }
        });

        task2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workerThread.addTaskToMessageQueue(taskTwo);
            }
        });
    }
    private Runnable taskOne = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG, "task one  " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    };
    private Runnable taskTwo = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG, "task two  " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    };


}