package com.example.validateusercredentials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WelcomePage extends AppCompatActivity {

    private Button mforgot, mlogin, showHideBtn;
    private EditText memail, mpassword;
    private String validEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        mforgot = findViewById(R.id.btnforgot);
        mlogin = findViewById(R.id.btnlogin);
        showHideBtn = findViewById(R.id.showHideBtn);

        memail = findViewById(R.id.etemail);
        mpassword = findViewById(R.id.etpassword);
        
        showHideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mpassword.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                    mpassword.setTransformationMethod((HideReturnsTransformationMethod.getInstance()));
                    showHideBtn.setText("Hide");
                } else {
                    mpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    showHideBtn.setText("Show");
                }
            }
        });


        mforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidEmail()) {
                    Toast.makeText(WelcomePage.this, "forgot password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidEmail() && isValidPassword()) {
                    Intent login = new Intent(getApplicationContext(), HomePage.class);
                    login.putExtra("mail", memail.getText().toString());
                    startActivity(login);
                    Toast.makeText(WelcomePage.this, "login", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean isValidEmail() {
        if (memail.getText().toString().length() > 1 && memail.getText().toString().matches(validEmail)) {
            return true;
        } else {
            memail.setError("Invalid Email");
        }
        return false;
    }

    private boolean isValidPassword() {
        if (mpassword.getText().toString().length() >= 8) {
            return true;
        } else {
            mpassword.setError("Your Password needs to be atleast 8 characters long");
        }
        return false;
    }
}