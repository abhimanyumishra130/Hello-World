package com.example.recyclerviewwe;

public class Student {
    private  String name;
    private int age;
    private String RollNo;

    public Student(String name, int age, String rollNo) {
        this.name = name;
        this.age = age;
        RollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRollNo() {
        return RollNo;
    }
}
