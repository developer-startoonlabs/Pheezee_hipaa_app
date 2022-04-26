package com.start.apps.pheezee.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RefreshAccessTokenResponse {
    @SerializedName("accessToken")
    @Expose
    private String accessToken;
    @SerializedName("accessTokenExpires")
    @Expose
    private String accessTokenExpires;
    @SerializedName("refreshToken")
    @Expose
    private String refreshToken;
    @SerializedName("refreshTokenExpires")
    @Expose
    private String refreshTokenExpires;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessTokenExpires() {return accessTokenExpires; }

    public void setAccessTokenExpires(String accessTokenExpires) {
        this.accessTokenExpires = accessTokenExpires;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getRefreshTokenExpires() {return refreshTokenExpires; }

    public void setRefreshTokenExpires(String refreshTokenExpires) {
        this.refreshTokenExpires = refreshTokenExpires;
    }
}
