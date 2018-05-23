package com.example.lenovo.retailshoppingapp;

public class CardModel {
    private String mUrl;
    private String mText;

    public String getUrl() {
        return mUrl;
    }

    public String getText() {
        return mText;
    }

    public CardModel(String url, String text) {
        this.mUrl = url;
        this.mText = text;
    }
}
