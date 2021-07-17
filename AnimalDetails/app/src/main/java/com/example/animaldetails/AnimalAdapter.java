package com.example.animaldetails;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalViewHolder> {

    ArrayList<Animal> animalList;
    private ItemClickListener itemClickListener;

    public AnimalAdapter(ArrayList<Animal> animalList, ItemClickListener itemClickListener) {
        this.animalList = animalList;
        this.itemClickListener= itemClickListener;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  AnimalViewHolder holder, int position) {

        Animal animal = animalList.get(position);
        holder.setData(animal,itemClickListener);

    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }
}
