package br.com.teti.kitha.model;

import java.io.Serializable;

public class LoginBean implements Serializable{

    private String userName;
    private String password;
    private boolean loginFailed;

    public LoginBean(boolean loginFailed) {
        this.userName = "";
        this.password = "";
        this.loginFailed = loginFailed;
    }

    public LoginBean() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoginFailed() {
        return loginFailed;
    }

    public void setLoginFailed(boolean loginFailed) {
        this.loginFailed = loginFailed;
    }
}
