package com.example.intentsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText etEdittext;
    private Button etButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEdittext=findViewById(R.id.intentEdit);
        etButton=findViewById(R.id.send);
        etButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(intent.ACTION_SEND);
                intent.putExtra(intent.EXTRA_TEXT,etEdittext.getText().toString());
                intent.setType("text/plain");

                startActivity(intent);
            }
        });
    }
}