package com.coursemanagement.coursemanagement.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Credentials")
public class SignupModel {
    private String fullname;
    private String username;
    private String password;
    private String re_password;

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRe_password() {
        return this.re_password;
    }

    public void setRe_password(String re_password) {
        this.re_password = re_password;
    }

    public SignupModel(String fullname , String username , String password , String re_password){
        this.fullname = fullname;
        this.password = password;
        this.username = username;
        this.re_password = re_password;
    }




}
