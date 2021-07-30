package com.example.callerapp;

public class ContactModel {
    String name;
    String number;
    public ContactModel(String name,String number){
        this.number=number;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
