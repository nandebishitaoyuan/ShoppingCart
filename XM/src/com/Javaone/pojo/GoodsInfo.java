package com.Javaone.pojo;
/**
 * 商品信息表
 */

import java.util.Date;

public class GoodsInfo {
    private Integer gId;
    private String gName;
    private Double gPrice;
    private String gClass;
    private Integer gAmount;
    private Date gDate;
    private String gImgurl;
    private Integer hLook;
    private String gIntro;
    private String gBrief;

    public GoodsInfo() {
    }

    public GoodsInfo(Integer gId, String gName, Double gPrice, String gClass, Integer gAmount, Date gDate, String gImgurl, Integer hLook, String gIntro, String gBrief) {
        this.gId = gId;
        this.gName = gName;
        this.gPrice = gPrice;
        this.gClass = gClass;
        this.gAmount = gAmount;
        this.gDate = gDate;
        this.gImgurl = gImgurl;
        this.hLook = hLook;
        this.gIntro = gIntro;
        this.gBrief = gBrief;
    }

    @Override
    public String toString() {
        return "goodsInfo{" +
                "gId=" + gId +
                ", gName='" + gName + '\'' +
                ", gPrice=" + gPrice +
                ", gClass='" + gClass + '\'' +
                ", gAmount=" + gAmount +
                ", gDate=" + gDate +
                ", gImgurl='" + gImgurl + '\'' +
                ", hLook=" + hLook +
                ", gIntro='" + gIntro + '\'' +
                ", gBrief='" + gBrief + '\'' +
                '}';
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public Double getgPrice() {
        return gPrice;
    }

    public void setgPrice(Double gPrice) {
        this.gPrice = gPrice;
    }

    public String getgClass() {
        return gClass;
    }

    public void setgClass(String gClass) {
        this.gClass = gClass;
    }

    public Integer getgAmount() {
        return gAmount;
    }

    public void setgAmount(Integer gAmount) {
        this.gAmount = gAmount;
    }

    public Date getgDate() {
        return gDate;
    }

    public void setgDate(Date gDate) {
        this.gDate = gDate;
    }

    public String getgImgurl() {
        return gImgurl;
    }

    public void setgImgurl(String gImgurl) {
        this.gImgurl = gImgurl;
    }

    public Integer gethLook() {
        return hLook;
    }

    public void sethLook(Integer hLook) {
        this.hLook = hLook;
    }

    public String getgIntro() {
        return gIntro;
    }

    public void setgIntro(String gIntro) {
        this.gIntro = gIntro;
    }

    public String getgBrief() {
        return gBrief;
    }

    public void setgBrief(String gBrief) {
        this.gBrief = gBrief;
    }
}
