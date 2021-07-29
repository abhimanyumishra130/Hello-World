package com.example.idenditycardproblemcontinuation;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DesignAdapter extends RecyclerView.Adapter<DesignViewHolder> {

    private ArrayList<IdentityModel> idList;
    private OnClickListener onClickListener;

    public DesignAdapter(ArrayList<IdentityModel> idList,OnClickListener onClickListener) {
        this.idList = idList;
        this.onClickListener=onClickListener;
    }
    @NonNull
    @Override
    public DesignViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.identity_card_item_layout,parent,false);

        return new DesignViewHolder(view,onClickListener);
    }



    @Override
    public void onBindViewHolder(@NonNull DesignViewHolder holder, int position) {
        IdentityModel design = idList.get(position);
        holder.setData(design);
    }

    @Override
    public int getItemCount() {
        return idList.size();
    }
}