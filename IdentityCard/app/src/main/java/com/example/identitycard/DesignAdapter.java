package com.example.identitycard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DesignAdapter extends RecyclerView.Adapter<DesignViewHolder> {

    private ArrayList<Design> idList;

    public DesignAdapter(ArrayList<Design> idList) {
        this.idList = idList;
    }
    @NonNull
    @Override
    public DesignViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);

        return new DesignViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull DesignViewHolder holder, int position) {
        Design design = idList.get(position);
        holder.setData(design);
    }

    @Override
    public int getItemCount() {
        return idList.size();
    }
}
