package com.sf_help.app.Models;

import android.widget.ImageView;

public class Categories {

    private String mCatName;
    private String mCatJobs;
    private int mCatImage;

    public Categories(String mCatName, String mCatJobs, int mCatImage) {
        this.mCatName = mCatName;
        this.mCatJobs = mCatJobs;
        this.mCatImage = mCatImage;
    }

    public Categories() {
    }

    public String getmCatName() {
        return mCatName;
    }

    public void setmCatName(String mCatName) {
        this.mCatName = mCatName;
    }

    public String getmCatJobs() {
        return mCatJobs;
    }

    public void setmCatJobs(String mCatJobs) {
        this.mCatJobs = mCatJobs;
    }

    public int getmCatImage() {
        return mCatImage;
    }

    public void setmCatImage(int mCatImage) {
        this.mCatImage = mCatImage;
    }
}
