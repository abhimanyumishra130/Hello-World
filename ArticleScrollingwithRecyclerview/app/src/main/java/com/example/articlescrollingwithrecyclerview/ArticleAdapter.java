package com.example.articlescrollingwithrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleViewHolder> {
    private ArrayList<ArticleModel> articleList;
    ItemClickedListener itemClickedListener;

    public ArticleAdapter(ArrayList<ArticleModel> articleList , ItemClickedListener itemClickedListener) {
        this.itemClickedListener=itemClickedListener;
        this.articleList = articleList;
    }

    @NonNull

    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ArticleViewHolder(view,itemClickedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull  ArticleViewHolder holder, int position) {
        ArticleModel articleModel = articleList.get(position);
        holder.setData(articleModel);

    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }
}
