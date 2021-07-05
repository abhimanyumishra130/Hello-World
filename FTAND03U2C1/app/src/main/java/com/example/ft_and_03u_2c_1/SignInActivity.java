package com.example.ft_and_03u_2c_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignInActivity extends AppCompatActivity {

    private Button etBack,etSignInPage,btnSignIn;
    private EditText etNames,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        itnitMain();
        etBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        etSignInPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isName() && isPassword()){
                    Intent intent = new Intent(SignInActivity.this,HomeActivity.class);
                    intent.putExtra("name",etNames.getText().toString());
                    startActivity(intent);
                }
            }
        });

    }

    private boolean isPassword() {
        boolean b=false;
        if(etPassword.getText().toString().length()>=6 && etPassword.getText().toString().matches("[0-9]+")){
            b=true;
        }else if(etPassword.getText().toString().length()<6){
            etPassword.setError("password is weak");
        }else{
            etPassword.setError("no alphabets allowed");
        }
        return b;
    }

    private boolean isName() {
        boolean b=false;
        String name = etNames.getText().toString();
        if(name.trim().length()>=4){
            b=true;
        }else{
            etNames.setError("minimum 4 characters");
        }
        return  b;
    }

    private void itnitMain() {
        etBack=findViewById(R.id.back);
        etSignInPage=findViewById(R.id.btnSignUpPage);
        etNames=findViewById(R.id.editNames);
        etPassword=findViewById(R.id.editPassword);

        btnSignIn=findViewById(R.id.btnSignIn);
    }
}