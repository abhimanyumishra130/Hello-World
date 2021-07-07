package com.example.recyclerviewwe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildStudentList();
        setRecyclerView();
    }

    private void buildStudentList() {

        studentList=new ArrayList<>();
        Student student1 = new Student("abhimanyu",20,"AND03_056");
        studentList.add(student1);
        for(int i=0;i<13;i++){
            Student student = new Student("student"+i,20,"AND03_056");
            studentList.add(student);
        }
    }

    private void setRecyclerView(){
        StudentAdapter studentAdapter = new StudentAdapter(studentList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(studentAdapter);
    }

    private void initViews(){
        recyclerView=findViewById(R.id.recyclerView);
    }
}