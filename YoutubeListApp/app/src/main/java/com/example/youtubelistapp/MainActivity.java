package com.example.youtubelistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<LinkModel> linkList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        buildList();
        setRecyclerView();
    }

    private void buildList() {
        for(int i=0; i<6; i++){
            linkList.add(new LinkModel("Lovely","https://www.youtube.com/watch?v=V1Pl8CzNzCw"));
            linkList.add(new LinkModel("Where we rise","https://www.youtube.com/watch?v=IxBop_tizx0"));
            linkList.add(new LinkModel("Alone","https://www.youtube.com/watch?v=1-xGerv5FOk"));
            linkList.add(new LinkModel("Stronger","https://www.youtube.com/watch?v=PsO6ZnUZI0g"));
            linkList.add(new LinkModel("Sunflower","https://www.youtube.com/watch?v=ApXoWvfEYVU"));
            linkList.add(new LinkModel("Animals","https://www.youtube.com/watch?v=0GVExpdmoDs"));
        }
    }

    private void setRecyclerView() {
        LinkAdapter adapter = new LinkAdapter(linkList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}