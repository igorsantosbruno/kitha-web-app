package br.com.teti.kitha.model;

import java.io.Serializable;

public class UserRegistrationBean implements Serializable{

    private String userName;
    private String password;
    private String name;
    private boolean userRegistrationFailed;

    public UserRegistrationBean(boolean userRegistrationFailed){

        this.userName = "";
        this.password = "";
        this.name = "";
        this.userRegistrationFailed = userRegistrationFailed;
    }

    public UserRegistrationBean(){

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isUserRegistrationFailed() {
        return userRegistrationFailed;
    }

    public void setUserRegistrationFailed(boolean userRegistrationFailed) {
        this.userRegistrationFailed = userRegistrationFailed;
    }
}
