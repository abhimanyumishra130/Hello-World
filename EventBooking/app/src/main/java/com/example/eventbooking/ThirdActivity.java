package com.example.eventbooking;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    private TextView txFirstName,txLastName,txEmail,txPhoneNumber,txNoOfSeat;
    private Button mbtCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        intitMain();
        setPreferenceText();
        mbtCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dateOfShow=PreferenceHelper.getIntFromPreference(ThirdActivity.this,"dateOfShow")+"";

                new AlertDialog.Builder(ThirdActivity.this)
                        .setTitle("Confirmation")
                        .setMessage("event is confirmed on this date "+dateOfShow)
                        .show();
            }
        });

    }

    private void setPreferenceText() {
        String first_name = PreferenceHelper.getStringFromPreference(ThirdActivity.this,"firstName");
        String last_name = PreferenceHelper.getStringFromPreference(ThirdActivity.this,"lastName");
        String email = PreferenceHelper.getStringFromPreference(ThirdActivity.this,"email");
        String phoneNo=PreferenceHelper.getIntFromPreference(ThirdActivity.this,"phoneNumber")+"";
        String noSeat=PreferenceHelper.getIntFromPreference(ThirdActivity.this,"noOfSeat")+"";


        txFirstName.setText(first_name);
        txLastName.setText(last_name);
        txEmail.setText(email);
        txPhoneNumber.setText(phoneNo);
        txNoOfSeat.setText(noSeat);

    }

    private void intitMain() {
        txFirstName=findViewById(R.id.tFirstName);
        txLastName=findViewById(R.id.tLastName);
        txEmail=findViewById(R.id.tEmail);
        txPhoneNumber=findViewById(R.id.tPhoneNumber);
        txNoOfSeat=findViewById(R.id.tNoOfSeat);
        mbtCheck=findViewById(R.id.check);

    }
}