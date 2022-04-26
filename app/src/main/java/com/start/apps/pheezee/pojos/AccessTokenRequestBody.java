package com.start.apps.pheezee.pojos;

public class AccessTokenRequestBody {
    private String refreshToken;


    public AccessTokenRequestBody(String refreshToken) {
        this.refreshToken = refreshToken;

    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String phizioemail) {
        this.refreshToken = refreshToken;
    }
}
