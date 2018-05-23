package com.example.lenovo.retailshoppingapp;

public class TopCategoryModel {
    private String mUrl;
    private String mTitle;
    private int mTotal;

    public TopCategoryModel(String url, String title, int total) {
        this.mUrl = url;
        this.mTitle = title;
        this.mTotal = total;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getTotal() {
        return mTotal;
    }
}
