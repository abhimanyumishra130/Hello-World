package com.example.identitycard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Design> idList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        buildList();
        setRecyclerView();
    }

    private void buildList() {
        for(int i=0; i<20; i++){
            Design bill_gates = new Design(R.drawable.bill_gates,"Microsoft",64,"Business");
            Design jeff_bezos = new Design(R.drawable.jeff_bezos,"Amazon",56,"Business");
            Design prateek_sukla = new Design(R.drawable.prateek_sukla,"Masai",31,"Business");
            idList.add(bill_gates);
            idList.add(jeff_bezos);
            idList.add(prateek_sukla);
        }
    }

    private void setRecyclerView() {
        DesignAdapter designAdapter = new DesignAdapter(idList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(designAdapter);
    }
}