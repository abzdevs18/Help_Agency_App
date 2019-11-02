package com.sf_help.app.Models;

import com.google.gson.annotations.SerializedName;

public class BiddersDialog {

    @SerializedName("userProf")
    String userProf;

    @SerializedName("workerId")
    String workerId;

    public String getUserProf() {
        return userProf;
    }

    public void setUserProf(String userProf) {
        this.userProf = userProf;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }
}
