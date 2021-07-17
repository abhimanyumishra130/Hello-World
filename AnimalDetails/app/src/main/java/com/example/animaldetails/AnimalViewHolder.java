package com.example.animaldetails;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class AnimalViewHolder extends RecyclerView.ViewHolder {

    private ImageView img;
    private TextView type,sound;
    private CardView cardView;
    private ItemClickListener itemClickListener;

    public AnimalViewHolder(@NonNull  View itemView) {
        super(itemView);
        initVeiw(itemView);
    }

    private void initVeiw(View itemView) {
        img=itemView.findViewById(R.id.animal);
        type= itemView.findViewById(R.id.type);
        sound=itemView.findViewById(R.id.sound);
        cardView=itemView.findViewById(R.id.cardView);
    }

    public void setData(Animal animal,ItemClickListener itemClickListener){
        img.setImageResource(animal.getImageId());
        type.setText(animal.getType());
        sound.setText(animal.getSound());
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onClicked(animal,getAdapterPosition());
            }
        });

    }
}
