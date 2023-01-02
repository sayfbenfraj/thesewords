package com.app.thesewords;

import java.io.Serializable;

public class Card implements Serializable {

    private String Title;
    private String Category ;
    private String Description ;
    private byte[] Thumbnail ;

    public Card() {
    }

    public Card(String title, String category, String description, byte[] thumbnail) {
        Title = title;
        Category = category;
        Description = description;
        Thumbnail = thumbnail;
    }


    public String getTitle() {
        return Title;
    }

    public String getCategory() {
        return Category;
    }

    public String getDescription() {
        return Description;
    }

    public byte[] getThumbnail() {
        return Thumbnail;
    }


    public void setTitle(String title) {
        Title = title;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setThumbnail(byte[] thumbnail) {
        Thumbnail = thumbnail;
    }
}