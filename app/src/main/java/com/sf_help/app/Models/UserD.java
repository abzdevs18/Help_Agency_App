package com.sf_help.app.Models;

import android.telecom.Call;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserD {

    @SerializedName("status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
