package com.example.articlescrollingwithrecyclerview;

public class ArticleModel {
    private String charName;
    private String role;
    private String content;
    private String author;
    private int imageId;


    public ArticleModel(String charName, String role, String content, String author, int imageId) {
        this.charName = charName;
        this.role = role;
        this.content = content;
        this.imageId = imageId;
        this.author=author;

    }

    public String getAuthor() {
        return author;
    }

    public String getCharName() {
        return charName;
    }

    public String getRole() {
        return role;
    }

    public String getContent() {
        return content;
    }

    public int getImageId() {
        return imageId;
    }
}
