package com.example.rememberme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView mtvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mtvText=findViewById(R.id.textView);

        String name=PreferenceHelper.getFromPreference(SecondActivity.this,"username");
        mtvText.setText(name);
    }
}