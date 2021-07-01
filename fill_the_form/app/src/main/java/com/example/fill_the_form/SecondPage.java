package com.example.fill_the_form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondPage extends AppCompatActivity {

    private TextView t1,t2,t3,t4,t5,t6,t7,t8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        intiMain();
        Intent intent = getIntent();
        String text1 = intent.getStringExtra("edit1");
        t1.setText(text1);
        String text2 = intent.getStringExtra("edit2");
        t2.setText(text2);
        String text3 = intent.getStringExtra("edit3");
        t3.setText(text3);
        String text4 = intent.getStringExtra("edit4");
        t4.setText(text4);
        String text5 = intent.getStringExtra("edit5");
        t5.setText(text5);
        String text6 = intent.getStringExtra("edit6");
        t6.setText(text6);
        String text7 = intent.getStringExtra("edit7");
        t7.setText(text7);
        String text8 = intent.getStringExtra("edit8");
        t8.setText(text8);
    }

    private void intiMain() {
        t1=findViewById(R.id.txt1);
        t2=findViewById(R.id.txt2);
        t3=findViewById(R.id.txt3);
        t4=findViewById(R.id.txt4);
        t5=findViewById(R.id.txt5);
        t6=findViewById(R.id.txt6);
        t7=findViewById(R.id.txt7);
        t8=findViewById(R.id.txt8);
    }
}