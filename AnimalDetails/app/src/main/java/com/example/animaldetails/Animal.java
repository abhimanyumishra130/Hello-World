package com.example.animaldetails;

public class Animal {
    private int imageId;
    private String type;
    private String sound;

    public Animal(int imageId, String type, String sound) {
        this.imageId = imageId;
        this.type = type;
        this.sound = sound;
    }

    public int getImageId() {
        return imageId;
    }

    public String getType() {
        return type;
    }

    public String getSound() {
        return sound;
    }
}
