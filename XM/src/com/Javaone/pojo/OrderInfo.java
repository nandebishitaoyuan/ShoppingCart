package com.Javaone.pojo;
/**
 * 订单信息表
 */

import java.util.Date;

public class OrderInfo {
    private Integer oId;
    private Date oDate;
    private Integer aId;
    private String oState;
    private String oRecname;
    private String oRecadr;
    private String oRectel;
    private Integer uId;
    private Double Ototalprice;

    public OrderInfo() {
    }

    public OrderInfo(Integer oId, Date oDate, Integer aId, String oState, String oRecname, String oRecadr, String oRectel, Integer uId,Double oTotalprice) {
        this.oId = oId;
        this.oDate = oDate;
        this.aId = aId;
        this.oState = oState;
        this.oRecname = oRecname;
        this.oRecadr = oRecadr;
        this.oRectel = oRectel;
        this.uId = uId;
        this.Ototalprice = oTotalprice;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "oId=" + oId +
                ", oDate=" + oDate +
                ", aId=" + aId +
                ", oState='" + oState + '\'' +
                ", oRecname='" + oRecname + '\'' +
                ", oRecadr='" + oRecadr + '\'' +
                ", oRectel='" + oRectel + '\'' +
                ", uId=" + uId +
                ", Ototalprice=" + Ototalprice +
                '}';
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public Date getoDate() {
        return oDate;
    }

    public void setoDate(Date oDate) {
        this.oDate = oDate;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getoState() {
        return oState;
    }

    public void setoState(String oState) {
        this.oState = oState;
    }

    public String getoRecname() {
        return oRecname;
    }

    public void setoRecname(String oRecname) {
        this.oRecname = oRecname;
    }

    public String getoRecadr() {
        return oRecadr;
    }

    public void setoRecadr(String oRecadr) {
        this.oRecadr = oRecadr;
    }

    public String getoRectel() {
        return oRectel;
    }

    public void setoRectel(String oRectel) {
        this.oRectel = oRectel;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Double getOtotalprice() {
        return Ototalprice;
    }
    public void setOtotalprice(Double ototalprice) {
        Ototalprice = ototalprice;
    }
}
