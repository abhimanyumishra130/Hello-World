package com.example.week11_day3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class secondPage extends AppCompatActivity {

    private TextView mtvusername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        mtvusername=findViewById(R.id.mtUsername);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        mtvusername.setText(username);
    }
}