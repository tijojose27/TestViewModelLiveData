package com.example.testviewmodellivedata.Model;


import java.util.ArrayList;

public class ParcelModel implements Comparable, Cloneable {

    private int id;
    private String c_id;
    private String account;
    private String district;
    private String billarea;
    private String type;
    private String houseNumber;
    private String street1;
    private String street2;
    private String city;
    private String zip;
    private String state;
    private String lat;
    private String lon;
    private Boolean is_selected;

    private ArrayList<RouteModel> routes;

    public ParcelModel() {
    }

    public ParcelModel(int id, String c_id, String account, String district, String billarea, String type, String houseNumber, String street1, String street2, String city, String zip, String state, String lat, String lon, Boolean is_selected) {
        this.id = id;
        this.c_id = c_id;
        this.account = account;
        this.district = district;
        this.billarea = billarea;
        this.type = type;
        this.houseNumber = houseNumber;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.zip = zip;
        this.state = state;
        this.lat = lat;
        this.lon = lon;
        this.is_selected = is_selected;
    }

    public void setRoutes(ArrayList<RouteModel> routes) {
        this.routes = routes;
    }



    public ArrayList<RouteModel> getRoutes() {
        return routes;
    }

    public int getId() {
        return id;
    }

    public String getC_id() {
        return c_id;
    }

    public String getAccount() {
        return account;
    }

    public String getDistrict() {
        return district;
    }

    public String getBillarea() {
        return billarea;
    }

    public String getType() {
        return type;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getStreet1() {
        return street1;
    }

    public String getStreet2() {
        return street2;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public String getState() {
        return state;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public Boolean getIs_selected() {
        return is_selected;
    }

    public void setIs_selected() {
        if(is_selected){
            is_selected = false;
        }else{
            is_selected = true;
        }
    }

    @Override
    public int compareTo(Object o) {
        ParcelModel compare = (ParcelModel) o;
        if(compare.getAccount().equals(this.getAccount()) && compare.getType().equals(this.getType()) && compare.getC_id().equals(this.getC_id())){
            return 0;
        }
        return 1;
    }

    @Override
    protected ParcelModel clone(){
        ParcelModel model = null;
        try{
            model = (ParcelModel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return model;
    }
}
