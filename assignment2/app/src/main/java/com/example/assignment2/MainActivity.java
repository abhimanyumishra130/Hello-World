package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mtvEdit;
    private TextView mtvTextView;
    private Button mtvButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtvEdit=findViewById(R.id.editText);
        mtvButton= findViewById(R.id.Button);
        mtvTextView= findViewById(R.id.textView);
      mtvEdit.addTextChangedListener(new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {
              int length=mtvEdit.length();
              String convert= mtvEdit.getText().toString();
              if (length>=6){
                  Toast.makeText(MainActivity.this,convert, Toast.LENGTH_SHORT).show();
              }
          }

          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {

          }

          @Override
          public void afterTextChanged(Editable s) {

          }
      });
        mtvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtvTextView.setText("Button Clicked");
            }
        });
    }
}