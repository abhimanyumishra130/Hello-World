package com.example.fill_the_form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private EditText e1,e2,e3,e4,e5,e6,e7,e8;
    private ImageButton img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMain();
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondPage.class);
                intent.putExtra("edit1",e1.getText().toString());
                intent.putExtra("edit2",e2.getText().toString());
                intent.putExtra("edit3",e3.getText().toString());
                intent.putExtra("edit4",e4.getText().toString());
                intent.putExtra("edit5",e5.getText().toString());
                intent.putExtra("edit6",e6.getText().toString());
                intent.putExtra("edit7",e7.getText().toString());
                intent.putExtra("edit8",e8.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void initMain() {
        e1=findViewById(R.id.ed1);
        e2=findViewById(R.id.ed2);
        e3=findViewById(R.id.ed3);
        e4=findViewById(R.id.ed4);
        e5=findViewById(R.id.ed5);
        e6=findViewById(R.id.ed6);
        e7=findViewById(R.id.ed7);
        e8=findViewById(R.id.ed8);
        img=findViewById(R.id.eImg);
    }
}