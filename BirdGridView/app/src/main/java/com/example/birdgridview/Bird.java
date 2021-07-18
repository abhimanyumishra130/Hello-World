package com.example.birdgridview;

public class Bird {
    private String birdName;
    private int img;
    public Bird(String birdName,int img){
        this.birdName= birdName;
        this.img= img;
    }

    public String getBirdName() {
        return birdName;
    }

    public int getImg() {
        return img;
    }
}
