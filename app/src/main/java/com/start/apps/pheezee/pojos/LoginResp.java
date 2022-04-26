package com.start.apps.pheezee.pojos;

public class LoginResp{
    private String phiziopassword;

    public LoginResp(String phiziopassword) {

        this.phiziopassword = phiziopassword;
    }


    public String getPhiziopassword() {
        return phiziopassword;
    }

    public void setPhiziopassword(String phiziopassword) {
        this.phiziopassword = phiziopassword;
    }
}