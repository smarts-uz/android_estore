package com.activeitzone.teamshopcms.Network.response;

import com.activeitzone.teamshopcms.Models.SliderImage;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SliderImageResponse {
    @SerializedName("data")
    @Expose
    private List<SliderImage> data = null;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("status")
    @Expose
    private Integer status;

    public List<SliderImage> getData() {
        return data;
    }

    public void setData(List<SliderImage> data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
