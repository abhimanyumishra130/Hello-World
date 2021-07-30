package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.secMessage);
        IntentFilter intentFilter = new IntentFilter("send.from.first.app");
        registerReceiver(new TestRecieverr(),intentFilter);


    }

    public class TestRecieverr extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"message from first app :   "+intent.getStringExtra("data"),Toast.LENGTH_SHORT).show();
            String str = intent.getStringExtra("data");
            text.setText(str);
        }
    }
}