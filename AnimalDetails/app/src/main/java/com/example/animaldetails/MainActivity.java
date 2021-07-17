package com.example.animaldetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    private ArrayList<Animal> animalList = new ArrayList<>();
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
            Animal animalDog = new Animal(R.drawable.dog,"dog","bow bow");
            Animal animalCat = new Animal(R.drawable.cat,"cat","meow meow");
            animalList.add(animalDog);
            animalList.add(animalCat);
        }
    }

    private void setRecyclerView() {
        AnimalAdapter animalAdapter = new AnimalAdapter(animalList,this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setAdapter(animalAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void onClicked(Animal animal, int position) {
        Toast.makeText(this, animal.getType()+" no. "+position/2, Toast.LENGTH_SHORT).show();
    }
}