package com.example.articlescrollingwithrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickedListener{

    private RecyclerView recyclerView;
    private ArrayList<ArticleModel> articleModelList = new ArrayList<>();
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intitView();
        buildList();
        setRecyclerView();
    }

    private void setRecyclerView() {
        ArticleAdapter articleAdapter = new ArticleAdapter(articleModelList,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(articleAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void buildList() {
        ArticleModel articleModel = new ArticleModel("N A R U T O","hero of the story","Naruto was serialized in Shueisha magazine, Weekly Shōnen Jump from 1999","Abhimanyu",R.drawable.naruto);
        articleModelList.add(articleModel);
        ArticleModel articleModel1 = new ArticleModel("S A S U K E","rival of hero","Sasuke Uchiha. Biography: Uchiha Sasuke belongs to the legendary Uchiha clan. He was born with Sharingan and uses it when he is in a critical situation. He is a very skilled fighter and has the potential to one day become a powerful ninja.","Rohit",R.drawable.sasuke);
        articleModelList.add(articleModel1);
        ArticleModel articleModel2 = new ArticleModel("N A R U T O","hero of the story","Naruto was serialized in Shueisha magazine, Weekly Shōnen Jump from 1999","Mausam",R.drawable.naruto);
        articleModelList.add(articleModel2);
        ArticleModel articleModel3 = new ArticleModel("S A S U K E","rival of hero","Sasuke Uchiha. Biography: Uchiha Sasuke belongs to the legendary Uchiha clan. He was born with Sharingan and uses it when he is in a critical situation. He is a very skilled fighter and has the potential to one day become a powerful ninja.","Aashutosh",R.drawable.sasuke);
        articleModelList.add(articleModel3);
        ArticleModel articleMode4 = new ArticleModel("N A R U T O","hero of the story","Naruto was serialized in Shueisha magazine, Weekly Shōnen Jump from 1999","rahul",R.drawable.naruto);
        articleModelList.add(articleMode4);
    }

    private void intitView() {
        recyclerView=findViewById(R.id.recyclerView);
        text=findViewById(R.id.author);

    }

    @Override
    public void onItemClicked(ArticleModel articleModel, int position) {

    }
}