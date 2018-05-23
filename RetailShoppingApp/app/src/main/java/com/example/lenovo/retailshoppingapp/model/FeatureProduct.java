package com.example.lenovo.retailshoppingapp.model;

public class FeatureProduct {
    private String mImageUrl;
    private String mProductTitle;
    private Integer mPrice;
    private Float mProductRating;

    public FeatureProduct(String imageUrl, String productTitle, Integer price, Float productRating) {
        this.mImageUrl = imageUrl;
        this.mProductTitle = productTitle;
        this.mPrice = price;
        this.mProductRating = productRating;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getProductTitle() {
        return mProductTitle;
    }

    public Integer getPrice() {
        return mPrice;
    }

    public Float getProductRating() {
        return mProductRating;
    }
}
