package com.sf_help.app.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignIn {

    @SerializedName("uNameEmail")
    private String uNameEmail;
    @SerializedName("uPassword")
    private String uPassword;
    //Due to the nested json response we need to create new class/model for: data & row
    @SerializedName("data")
    @Expose
    private Data data;

    @SerializedName("row")
    @Expose
    private Row row;

    public String getuNameEmail() {
        return uNameEmail;
    }

    public void setuNameEmail(String uNameEmail) {
        this.uNameEmail = uNameEmail;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Row getRow() {
        return row;
    }

    public void setRow(Row row) {
        this.row = row;
    }
}
