package com.example.and03unit_2c_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText email, password;
    private Button login;
    private CheckBox remember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        boolean value = PreferenceHelper.booleanFromPreference(MainActivity.this,"check");
        if(value){
            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);
        }else {
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (checkEmail() && checkPassword()) {
                        Toast.makeText(MainActivity.this, "button clicked", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                        startActivity(intent);

                    }
                }
            });
        }

        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    PreferenceHelper.booleanToPreference(MainActivity.this,"check",true);
                    PreferenceHelper.writeToPreference(MainActivity.this,"email",email.getText().toString());
                }else if(!buttonView.isChecked()){
                    PreferenceHelper.booleanToPreference(MainActivity.this,"check",false);
                }

            }
        });

    }





    private boolean checkEmail() {
        boolean b = false;
        if (email.getText().toString().matches("[a-z0-9._-]+@[a-z]+\\.+[a-z]+")) {
            b = true;
        }else{
            email.setError("InValid Email");
        }
        return b;
    }

    public boolean checkPassword() {
        boolean b = false;
        if (password.getText().toString().length() >= 6) {
            b = true;
        } else {
            password.setError(" Password is very short");
        }
        return b;
    }


    private void initView() {
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        remember=findViewById(R.id.rememberMe);

    }
}