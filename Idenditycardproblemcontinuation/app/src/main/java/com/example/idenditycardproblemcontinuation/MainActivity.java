package com.example.idenditycardproblemcontinuation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private ArrayList<IdentityModel> idList = new ArrayList<>();
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
            IdentityModel bill_gates = new IdentityModel(R.drawable.bill_gates,"Microsoft",64,"Business");
            IdentityModel jeff_bezos = new IdentityModel(R.drawable.jeff_bezos,"Amazon",56,"Business");
            IdentityModel prateek_sukla = new IdentityModel(R.drawable.prateek_sukla,"Masai",31,"Business");
            idList.add(bill_gates);
            idList.add(jeff_bezos);
            idList.add(prateek_sukla);
        }
    }

    private void setRecyclerView() {
        DesignAdapter designAdapter = new DesignAdapter(idList,this);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(designAdapter);
    }

    @Override
    public void OnClicked(IdentityModel model, int position) {

        String str = model.getCompany();
        int age = model.getAge();

        new AlertDialog.Builder(this)
                .setTitle("Company Name: "+str)
                .setMessage("Age "+age)

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with delete operation
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }
}