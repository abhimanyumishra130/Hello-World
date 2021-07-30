package com.example.callerapp;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ContactViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private LinearLayout linearLayout;
    private OnClickListener onClickListener;
    public ContactViewHolder(@NonNull View itemView,OnClickListener onClickListener) {
        super(itemView);
        this.onClickListener=onClickListener;
        initView();
    }

    private void initView() {
        linearLayout= itemView.findViewById(R.id.LinearLayout);
        name = itemView.findViewById(R.id.name);
    }

    public void setData(ContactModel model){
        name.setText(model.getName());
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.OnClicked(model,getAdapterPosition());
            }
        });
    }
}
