package com.example.listscreen;

// 사용자 계정 정보 모델 클래스


public class UserAccount
{
    private String idToken;  // Firebase Uid (고유 토큰정보)
    private String phoneId;  // 휴대폰 번호 (아이디)
    private String password;  // 비밀번호

    public UserAccount() {}

    public String getIdToken() { return idToken; }

    public void setIdToken(String idToken) { this.idToken = idToken; }

    public String getPhoneId() { return phoneId; }

    public void setPhoneId(String phoneId) { this.phoneId = phoneId; }

    public  String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}
