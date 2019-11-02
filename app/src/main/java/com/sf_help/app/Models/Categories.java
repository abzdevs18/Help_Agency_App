package com.sf_help.app.Models;

import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;

public class Categories {

    @SerializedName("catId")
    private String catId;

    @SerializedName("catName")
    private String catName;

    @SerializedName("catImage")
    private String catImage;

    @SerializedName("numJobCat")
    private String numJobCat;

    public Categories(String catId, String catName, String catImage, String numJobCat) {
        this.catId = catId;
        this.catName = catName;
        this.catImage = catImage;
        this.numJobCat = numJobCat;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatImage() {
        return catImage;
    }

    public void setCatImage(String catImage) {
        this.catImage = catImage;
    }

    public String getNumJobCat() {
        return numJobCat;
    }

    public void setNumJobCat(String numJobCat) {
        this.numJobCat = numJobCat;
    }
}
