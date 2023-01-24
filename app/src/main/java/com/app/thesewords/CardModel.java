package com.app.thesewords;


public class CardModel {

    private String title;
    private String category;
    byte[]  thumbnail;


    public CardModel(String title, String category, byte[] thumbnail) {
        this.title = title;
        this.category = category;
        this.thumbnail = thumbnail;
    }


    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }
    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }
}