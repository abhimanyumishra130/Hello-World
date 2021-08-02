package com.example.notifyadapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotifyAdapter extends RecyclerView.Adapter<NotifyViewHolder> {

    private ArrayList<NotifyModel> modelList;
    private OnClickListener onClickListener;
    public NotifyAdapter(ArrayList<NotifyModel> modelList,OnClickListener onClickListener){
        this.modelList=modelList;
        this.onClickListener = onClickListener;
    }
    @NonNull
    @Override
    public NotifyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new NotifyViewHolder(view,onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull  NotifyViewHolder holder, int position) {

        NotifyModel model = modelList.get(position);
        holder.setData(model);

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}

class NotifyViewHolder extends RecyclerView.ViewHolder{

    private Button text;
    private  OnClickListener onClickListener;

    public NotifyViewHolder(@NonNull  View itemView , OnClickListener onClickListener) {
        super(itemView);
        this.onClickListener=onClickListener;
        text = itemView.findViewById(R.id.btnBooks);

    }
    public void setData(NotifyModel model){
        text.setText(model.getText());
        final boolean[] val = {true};
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(val[0]){
                    text.setBackgroundColor(Color.parseColor("#0583EA"));
                    text.setTextColor(Color.WHITE);
                    val[0] = false;
                }else{
                    text.setBackgroundColor(Color.WHITE);
                    text.setTextColor(Color.parseColor("#0583EA"));
                    val[0] = true;
                }
            }
        });
    }
}
