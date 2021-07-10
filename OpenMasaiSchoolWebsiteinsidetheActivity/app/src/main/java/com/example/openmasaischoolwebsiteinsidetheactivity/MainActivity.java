package com.example.openmasaischoolwebsiteinsidetheactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mtvBtn;
    private WebView mtvWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtvBtn=findViewById(R.id.Open);
        mtvWeb=findViewById(R.id.View);
        mtvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtvWeb.getSettings().getJavaScriptEnabled();
                mtvWeb.loadUrl("https://www.masaischool.com/");
            }
        });
    }
}