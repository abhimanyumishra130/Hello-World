package com.example.ft_and_03u_2c_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    private Button etBack,etSignInPage,btnSignUp;
    private EditText etName, etEmail, etPassword;
    protected String strEmail="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        intitMain();
        etBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        etSignInPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isName()  && isEmail() && isPassword()){
                    Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                    intent.putExtra("name",etName.getText().toString());
                    startActivity(intent);
                }
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

            private boolean isEmail() {
                boolean b=false;
                if (etEmail.getText().toString().matches(strEmail)){
                    b=true;
                }else{
                    etEmail.setError("invalid email");
                }
                return b;
            }

            private boolean isName() {
                boolean b=false;
                String name = etName.getText().toString();
                if(name.trim().length()>=4){
                    b=true;
                }else{
                    etName.setError("minimum 4 characters");
                }
                return  b;
            }
        });
    }

    private void intitMain() {
        etBack=findViewById(R.id.back);
        etSignInPage=findViewById(R.id.btnSignInPage);
        etName=findViewById(R.id.EditName);
        etEmail=findViewById(R.id.EditEmail);
        etPassword=findViewById(R.id.EditPassword);
        btnSignUp=findViewById(R.id.btnSignUp);
    }


}