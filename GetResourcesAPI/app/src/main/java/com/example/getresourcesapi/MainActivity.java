package com.example.getresourcesapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etEditText;
    private Button etSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEditText= findViewById(R.id.editText);
        etSend = findViewById(R.id.sendData);

        etSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondPage.class);
                if(etEditText.getText().toString()!=null) {
                    intent.putExtra("data", etEditText.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}