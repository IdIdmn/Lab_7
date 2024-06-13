package com.example.matchtracker.Entity;

import android.net.Uri;

public class News {

    private int imageResId;

    private Uri imageURI;

    private String newsTitle;

    private String newsText;

    private String newsDate;

    private boolean isContainsImage;

    private boolean isExternallyLoaded = false;

    public News(String newsTitle, String newsText, String newsDate, boolean isContainsImage) {
        this.newsTitle = newsTitle;
        this.newsText = newsText;
        this.newsDate = newsDate;
        this.isContainsImage = isContainsImage;
    }

    public News(){}

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public boolean isExternallyLoaded() {
        return isExternallyLoaded;
    }

    public void setExternallyLoaded(boolean externallyLoaded) {
        isExternallyLoaded = externallyLoaded;
    }

    public Uri getImageURI() {
        return imageURI;
    }

    public void setImageURI(Uri imageURI) {
        this.imageURI = imageURI;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsText() {
        return newsText;
    }

    public void setNewsText(String newsText) {
        this.newsText = newsText;
    }

    public String getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }

    public boolean isContainsImage() {
        return isContainsImage;
    }

    public void setContainsImage(boolean containsImage) {
        isContainsImage = containsImage;
    }
}
