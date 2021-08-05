package com.example.dynamicfragments;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FragmentAdapter extends RecyclerView.Adapter<FragmentViewHolder> {

    private ArrayList<ResponseDTO> list ;
    public FragmentAdapter(ArrayList<ResponseDTO> list ){
        this.list = list;

    }
    @NonNull
    @NotNull
    @Override
    public FragmentViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);

        return new FragmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FragmentViewHolder holder, int position) {
        ResponseDTO model = list.get(position);
        holder.setData(model);
    }

    public void update(ArrayList<ResponseDTO> list){
        this.list=list;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}

 class FragmentViewHolder extends RecyclerView.ViewHolder{

    private ImageView image;
    private TextView title;
    private TextView subtitle;

    public FragmentViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        initView(itemView);
    }

     private void initView(View itemView) {
         image= itemView.findViewById(R.id.ImageView);
         title = itemView.findViewById(R.id.textView1);
         subtitle = itemView.findViewById(R.id.textView2);

     }

     public void setData(ResponseDTO model){
        Glide.with(image).load(model.getImage()).into(image);
        title.setText(model.getTitle());
        subtitle.setText(model.getSubTitle());
     }
 }
