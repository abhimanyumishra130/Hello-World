package com.example.callerapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ContactViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        initView();
    }

    private void initView() {
        name = itemView.findViewById(R.id.name);
    }

    public void setData(ContactModel model){
        name.setText(model.getName());
    }
}
