package com.example.week11_day3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mEtUsername,mEtPassword,mEtEmail;
    private Button mBtnLogin;
    private String validEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEmail() && isUsername() && isPassword()){
                    Intent intent = new Intent(MainActivity.this,secondPage.class);
                    intent.putExtra("username",mEtUsername.getText().toString());
                    startActivity(intent);
                }

            }
        });

    }

    private void initViews() {
        mEtUsername=findViewById(R.id.etUsername);
        mEtPassword= findViewById(R.id.etPassword);
        mEtEmail=findViewById(R.id.etEmail);
        mBtnLogin=findViewById(R.id.btnLogin);
    }
    public  boolean isEmail(){
        if(mEtEmail.getText().toString().length()>1 && mEtEmail.getText().toString().matches(validEmail)){
            return true;
        }else{
            mEtEmail.setError("Invalid Email!");
        }
        return false;
    }
    public boolean isUsername(){
        if(mEtUsername.getText().toString().length()>=4){
            return true;
        }else{
            mEtUsername.setError("Invalid Username!");
        }
        return false;
    }
    public boolean isPassword(){
        if(mEtPassword.getText().toString().length()>=6){
            return true;
        }else{
            mEtPassword.setError("Password should be minimum 6 digits");
        }
        return false;
    }
}