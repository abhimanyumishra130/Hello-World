package com.example.callerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    private RecyclerView recyclerView;
    private ArrayList<ContactModel> contactList = new ArrayList<>();
    private static final int REQUEST_CODE= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.contact);
        setRecyclerView();
        builList();
        String[] permission  = {Manifest.permission.CALL_PHONE};
        ActivityCompat.requestPermissions(MainActivity.this,permission,REQUEST_CODE);
    }



    private void builList() {
        for(int i=0; i<20; i++){
            ContactModel model = new ContactModel("Abhimanyu Mishra","9764119103");
            contactList.add(model);
            ContactModel model1 = new ContactModel("Mausam singh","1234567891");
            contactList.add(model1);
            ContactModel model2 = new ContactModel("Rohit sharma","9817563869");
            contactList.add(model2);
        }
    }

    private void setRecyclerView() {
        ContactAdapter adapter = new ContactAdapter(contactList,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void OnClicked(ContactModel model, int position) {

        String permission = Manifest.permission.CALL_PHONE;
        int res = getBaseContext().checkCallingOrSelfPermission(permission);
        Toast.makeText(this, ""+(res == PackageManager.PERMISSION_GRANTED), Toast.LENGTH_SHORT).show();
        if(res == PackageManager.PERMISSION_GRANTED){
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + model.getNumber()));
            startActivity(callIntent);
        }else{
            Intent intent = new Intent(MainActivity.this,Check.class);
            startActivity(intent);
        }

    }
}