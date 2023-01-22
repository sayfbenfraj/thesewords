package com.app.thesewords;


public class Card{

    private String title;
    private String category;
    private String thumbnail;

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }
    public String getThumbnail() {
        return thumbnail;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Card{" +
                "title='" + title + '\'' +
                ", category=" + category +
                ", thumbnail=" + thumbnail +
                '}';
    }
}