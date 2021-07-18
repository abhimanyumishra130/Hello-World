package com.example.birdgridview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ClickListener{
    private ArrayList<Bird> birdList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        buildList();
        setRecyclerView();
    }

    private void buildList() {
        for(int i=0; i<40; i++){
             Bird yellow_bird = new Bird("Yellow Bird",R.drawable.yellow_bird);
             Bird blue_bird = new Bird("Blue Bird",R.drawable.blue_bird);
             Bird pink_Bird = new Bird("Pink Bird",R.drawable.pink_bird);
             Bird purple_bird = new Bird("Purple Bird",R.drawable.purple_bird);
             if(i%4==0) birdList.add(yellow_bird);
             else if(i%4==1) birdList.add(blue_bird);
             else if(i%4==2) birdList.add(pink_Bird);
             else if(i%4==3)  birdList.add(purple_bird);
        }
    }

    private void setRecyclerView() {
        BirdAdapter birdAdapter = new BirdAdapter(birdList,this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,4);
        recyclerView.setAdapter(birdAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    private void initView() {
        recyclerView=findViewById(R.id.recyclerView);
    }

    @Override
    public void onClick(Bird bird) {
        Toast.makeText(this, bird.getBirdName(), Toast.LENGTH_SHORT).show();
    }
}