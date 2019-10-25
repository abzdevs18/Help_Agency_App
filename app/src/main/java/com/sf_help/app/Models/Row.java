package com.sf_help.app.Models;

import com.google.gson.annotations.SerializedName;

public class Row {
    // TODO: 10/25/2019 Used for login response

    @SerializedName("fId")
    private String fId;

    @SerializedName("userId")
    private String userId;

    @SerializedName("usrEmail")
    private String usrEmail;

    public String getfId() {
        return fId;
    }

    public void setfId(String fId) {
        this.fId = fId;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
