package com.example.recyclerclickview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements itemClickListener {
    private RecyclerView recyclerView;
    private ArrayList<StudentModel> arrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiView();
        buildList();
        setRecyclerView();
    }

    private void setRecyclerView() {
        StudentAdapter studentAdapter = new StudentAdapter(arrayList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(studentAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void intiView() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    private void buildList() {
        for (int i = 0; i < 100; i++) {
            StudentModel studentModel = new StudentModel("abhimanyu", 20, "mumbai", "22/11/2000", R.drawable.java);
            arrayList.add(studentModel);
        }
    }

    @Override
    public void onItemClicked(StudentModel model, int position) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Hey this is the Data")
                .setMessage(
                        model.getName() + "\n"
                                + model.getAge() + "\n"
                                + model.getDob() + "\n"
                                + model.getAddress()
                ).
                        setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).
                        setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).
                        show();
    }
}