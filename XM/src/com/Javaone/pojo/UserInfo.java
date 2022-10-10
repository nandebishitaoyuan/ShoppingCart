package com.Javaone.pojo;

/**
 * 用户信息表
 */
public class UserInfo {
    private Integer uId;
    private String uName;
    private String uPwd;
    private String uEmail;

    public UserInfo() {
    }

    public UserInfo(Integer uId, String uName, String uPwd, String uEmail) {
        this.uId = uId;
        this.uName = uName;
        this.uPwd = uPwd;
        this.uEmail = uEmail;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPwd='" + uPwd + '\'' +
                ", uEmail='" + uEmail + '\'' +
                '}';
    }
}
