package com.example.analysethelifecyclemethods;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Tag","onCreate");
        
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Tag","onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Tag","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Tag","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Tag","OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Tag","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Tag","onDestroy");
    }
}