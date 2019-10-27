package com.sf_help.app.Models;

import com.google.gson.annotations.SerializedName;

public class GetJob {

    @SerializedName("jId")
    private String jId;

    @SerializedName("jTitle")
    private String jTitle;

    @SerializedName("jType")
    private String jType;

    @SerializedName("jReq")
    private String jReq;

    @SerializedName("jDeadline")
    private String jDeadline;

    @SerializedName("jSalary")
    private String jSalary;

    @SerializedName("jDesc")
    private String jDesc;

    @SerializedName("jTags")
    private String jTags;

    public String getjId() {
        return jId;
    }

    public void setjId(String jId) {
        this.jId = jId;
    }

    public String getjTitle() {
        return jTitle;
    }

    public void setjTitle(String jTitle) {
        this.jTitle = jTitle;
    }

    public String getjType() {
        return jType;
    }

    public void setjType(String jType) {
        this.jType = jType;
    }

    public String getjReq() {
        return jReq;
    }

    public void setjReq(String jReq) {
        this.jReq = jReq;
    }

    public String getjDeadline() {
        return jDeadline;
    }

    public void setjDeadline(String jDeadline) {
        this.jDeadline = jDeadline;
    }

    public String getjSalary() {
        return jSalary;
    }

    public void setjSalary(String jSalary) {
        this.jSalary = jSalary;
    }

    public String getjDesc() {
        return jDesc;
    }

    public void setjDesc(String jDesc) {
        this.jDesc = jDesc;
    }

    public String getjTags() {
        return jTags;
    }

    public void setjTags(String jTags) {
        this.jTags = jTags;
    }
}
