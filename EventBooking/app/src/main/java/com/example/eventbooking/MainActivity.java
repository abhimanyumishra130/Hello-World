package com.example.eventbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button mbtSecondPage;
    private EditText etFirstName, etSecondName, etEmail, etPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intitMain();
        mbtSecondPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);

                PreferenceHelper.writeStringToPreference(MainActivity.this,"firstName",etFirstName.getText().toString());
                PreferenceHelper.writeStringToPreference(MainActivity.this,"lastName",etSecondName.getText().toString());
                PreferenceHelper.writeStringToPreference(MainActivity.this,"email",etEmail.getText().toString());
                PreferenceHelper.writeIntToPreference(MainActivity.this,"phoneNumber",Integer.parseInt(etPhoneNumber.getText().toString()));

                startActivity(intent);
            }
        });
    }

    private void intitMain() {
        mbtSecondPage=findViewById(R.id.secondPage);
        etFirstName=findViewById(R.id.FirstName);
        etSecondName=findViewById(R.id.LastName);
        etEmail=findViewById(R.id.Email);
        etPhoneNumber=findViewById(R.id.PhoneNumber);
    }
}