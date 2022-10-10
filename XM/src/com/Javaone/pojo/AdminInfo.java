package com.Javaone.pojo;

/**
 * 管理员信息
 */
public class AdminInfo {
    private Integer aid;
    private String aName;
    private String aPwd;
    private String aLevel;

    public AdminInfo() {
    }

    public AdminInfo(Integer aid, String aName, String aPwd, String aLevel) {
        this.aid = aid;
        this.aName = aName;
        this.aPwd = aPwd;
        this.aLevel = aLevel;
    }

    @Override
    public String toString() {
        return "AdminInfo{" +
                "aid=" + aid +
                ", aName='" + aName + '\'' +
                ", aPwd='" + aPwd + '\'' +
                ", aLevel='" + aLevel + '\'' +
                '}';
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaPwd() {
        return aPwd;
    }

    public void setaPwd(String aPwd) {
        this.aPwd = aPwd;
    }

    public String getaLevel() {
        return aLevel;
    }

    public void setaLevel(String aLevel) {
        this.aLevel = aLevel;
    }
}
