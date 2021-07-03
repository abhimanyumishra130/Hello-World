package com.example.intentreciever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondPage extends AppCompatActivity {
    private TextView etText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        etText=findViewById(R.id.intenText);

        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                handleSendText(intent); // Handle text being sent
            }
        }
    }

    private void handleSendText(Intent intent) {
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        if (sharedText != null) {
            etText.setText(sharedText);
        }
    }
}