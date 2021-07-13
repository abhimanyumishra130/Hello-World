package com.example.articlescrollingwithrecyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleViewHolder extends RecyclerView.ViewHolder {

    private LinearLayout linearLayout;
    private TextView etCharName, etAuthor, etContent;
    private ImageView etImageId;
    private  ItemClickedListener itemClickedListener;
    public ArticleViewHolder(@NonNull  View itemView , ItemClickedListener itemClickedListener) {
        super(itemView);
        initView(itemView);
        this.itemClickedListener=itemClickedListener;
    }

    private void initView(View itemView) {
        etCharName = itemView.findViewById(R.id.charName);
        etContent =  itemView.findViewById(R.id.contentChar);
        etAuthor = itemView.findViewById(R.id.author);
        etImageId = itemView.findViewById(R.id.tvImage);
        linearLayout = itemView.findViewById(R.id.linearLayout);
    }
    public  void  setData(ArticleModel articleModel){
        etImageId.setImageResource(articleModel.getImageId());
        etCharName.setText(articleModel.getCharName());
        etContent.setText(articleModel.getContent());

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etAuthor.setText(articleModel.getAuthor());
            }
        });
    }
}
