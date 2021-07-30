package com.example.callerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    private OnClickListener onClickListener;
    private ArrayList<ContactModel> contactList;
    public ContactAdapter(ArrayList<ContactModel> contactList,OnClickListener onClickListener){
        this.contactList= contactList;
        this.onClickListener=onClickListener;
    }
    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_litem_layout,parent,false);
        return new ContactViewHolder(view,onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull  ContactViewHolder holder, int position) {

        ContactModel model = contactList.get(position);
        holder.setData(model);
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }
}
