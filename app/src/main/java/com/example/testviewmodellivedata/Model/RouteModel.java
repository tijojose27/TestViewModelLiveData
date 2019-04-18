package com.example.testviewmodellivedata.Model;

public class RouteModel {

    private String c_id;
    private String account;
    private String num;
    private String type;
    private String mon;
    private String tue;
    private String wed;
    private String thu;
    private String fri;
    private String sat;
    private String sun;
    private String freq;
    private String stopNextDate;

    public RouteModel() {
    }

    public RouteModel(String c_id, String account, String num, String type, String mon, String tue, String wed, String thu, String fri, String sat, String sun, String freq, String stopNextDate) {
        this.c_id = c_id;
        this.account = account;
        this.num = num;
        this.type = type;
        this.mon = mon;
        this.tue = tue;
        this.wed = wed;
        this.thu = thu;
        this.fri = fri;
        this.sat = sat;
        this.sun = sun;
        this.freq = freq;
        this.stopNextDate = stopNextDate;
    }

    public String getC_id() {
        return c_id;
    }

    public String getAccount() {
        return account;
    }

    public String getNum() {
        return num;
    }

    public String getType() {
        return type;
    }

    public String getMon() {
        return mon;
    }

    public String getTue() {
        return tue;
    }

    public String getWed() {
        return wed;
    }

    public String getThu() {
        return thu;
    }

    public String getFri() {
        return fri;
    }

    public String getSat() {
        return sat;
    }

    public String getSun() {
        return sun;
    }

    public String getFreq() {
        return freq;
    }

    public String getStopNextDate() {
        return stopNextDate;
    }
}
