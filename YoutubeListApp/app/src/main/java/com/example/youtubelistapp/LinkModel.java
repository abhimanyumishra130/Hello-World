package com.example.youtubelistapp;

public class LinkModel {
    String name;
    String link;
    public LinkModel(String name , String link){
        this.name = name;
        this.link= link;
    }

    public String getName() {
        return name;
    }
    public String getLink(){
        return link;
    }
}
