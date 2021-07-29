package com.example.idenditycardproblemcontinuation;

public class IdentityModel {
    private int imageId;
    private String company;
    private int age;
    private String profession;

    public IdentityModel(int imageId, String company, int age, String profession) {
        this.imageId = imageId;
        this.company = company;
        this.age = age;
        this.profession = profession;
    }

    public int getImageId() {
        return imageId;
    }

    public String getCompany() {
        return company;
    }

    public int getAge() {
        return age;
    }

    public String getProfession() {
        return profession;
    }
}
