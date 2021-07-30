package com.example.loadtenanimalsprofileinafragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Animal_Fragment extends Fragment {

    RecyclerView recyclerView;
    private ArrayList<Animal> animalList= new ArrayList<>();

    @Override
    public void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buildList();

    }

    private void buildList() {
        for(int i=0;i<20;i++){
            Animal one = new Animal("dog",R.drawable.dog);
            animalList.add(one);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animal_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        setRecyclerViewI();
    }

    private void setRecyclerViewI() {
        AnimalAdapter adapter = new AnimalAdapter(animalList);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initView(View view) {
           recyclerView=view.findViewById(R.id.recyclerView);
    }
}