package com.example.week11_day3_ass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mEtEmail, mEtCC, mEtContent;
    private Button mEtBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiMain();
        mEtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
// The intent does not have a URI, so declare the "text/plain" MIME type
                emailIntent.setType("plain/text");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {mEtEmail.getText().toString()}); // recipients
                emailIntent.putExtra(Intent.EXTRA_CC, new String[] {mEtCC.getText().toString()});
                emailIntent.putExtra(Intent.EXTRA_TEXT, mEtContent.getText().toString());
                startActivity(emailIntent);

// You can also attach multiple items by passing an ArrayList of Uris
            }
        });

    }

    private void intiMain() {
        mEtEmail=findViewById(R.id.mtEmail);
        mEtCC=findViewById(R.id.mtCC);
        mEtContent=findViewById(R.id.mtContent);
        mEtBtn=findViewById(R.id.BtnSend);
    }
}