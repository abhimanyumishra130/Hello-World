package com.example.ft_and_03u_2c_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView etvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        etvName=findViewById(R.id.Name);
        Intent intent=getIntent();
        String str = intent.getStringExtra("name");
        etvName.setText(str);
        //startActivity(intent);
    }
}