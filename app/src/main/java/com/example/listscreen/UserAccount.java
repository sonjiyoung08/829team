package com.example.listscreen;



public class UserAccount {
    private String idToken; // Firebase User UID
    private String email;
    private String password;

    public UserAccount() {
    }

    public UserAccount(String idToken, String email, String password) {
        this.idToken = idToken;
        this.email = email;
        this.password = password;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
