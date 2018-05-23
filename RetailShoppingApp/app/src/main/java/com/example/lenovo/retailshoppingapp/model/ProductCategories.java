package com.example.lenovo.retailshoppingapp.model;

public class ProductCategories {
    private String mUrl;
    private String mTitle;
    private Integer mDiscount;

    public ProductCategories(String url, String title, Integer discount) {
        this.mUrl = url;
        this.mTitle = title;
        this.mDiscount = discount;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public Integer getDiscount() {
        return mDiscount;
    }
}
