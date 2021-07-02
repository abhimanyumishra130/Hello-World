package com.example.validateusercredentials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    private TextView mreceivedemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        mreceivedemail=findViewById(R.id.tvmail);
        Intent rec_mail=getIntent();
        String str = rec_mail.getStringExtra("mail");
        mreceivedemail.setText(str);
    }
}