package com.example.eventbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private Button mbtThirdPage;
    private TextView emtFirstName, emtLastName, emtEmail;
    private  EditText emtNoOfSeat, emtDayOfShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initMain();
        getPreferencesFromActivity();


        mbtThirdPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);

                PreferenceHelper.writeIntToPreference(SecondActivity.this,"noOfSeat",Integer.parseInt(emtNoOfSeat.getText().toString()));
                PreferenceHelper.writeIntToPreference(SecondActivity.this,"dateOfShow",Integer.parseInt(emtDayOfShow.getText().toString()));
                startActivity(intent);
            }
        });
    }


    private void getPreferencesFromActivity() {
        String first_name = PreferenceHelper.getStringFromPreference(SecondActivity.this,"firstName");
        String last_name = PreferenceHelper.getStringFromPreference(SecondActivity.this,"lastName");
        String email = PreferenceHelper.getStringFromPreference(SecondActivity.this,"email");


        emtFirstName.setText(first_name);
        emtLastName.setText(last_name);
        emtEmail.setText(email);
    }

    private void initMain() {
        mbtThirdPage=findViewById(R.id.thirdPage);
        emtFirstName=findViewById(R.id.firstName);
        emtLastName=findViewById(R.id.lastName);
        emtEmail=findViewById(R.id.email);
        emtNoOfSeat=findViewById(R.id.NoOfSeats);
        emtDayOfShow=findViewById(R.id.DateOfShow);

    }
}