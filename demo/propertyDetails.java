package com.example.demo;

public class propertyDetails {
    String ownerName;
    String kashtKarName;
    int khewatNo;
    String propertyType;
    double propertyDimension;
    int khatoniNo;
    String mozaNo;

    public propertyDetails(String ownerName, String kashtKarName, int khewatNo, String propertyType, double propertyDimension, int khatoniNo, String mozaNo) {
        this.ownerName = ownerName;
        this.kashtKarName = kashtKarName;
        this.khewatNo = khewatNo;
        this.propertyType = propertyType;
        this.propertyDimension = propertyDimension;
        this.khatoniNo = khatoniNo;
        this.mozaNo = mozaNo;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getKashtKarName() {
        return kashtKarName;
    }

    public void setKashtKarName(String kashtKarName) {
        this.kashtKarName = kashtKarName;
    }

    public int getKhewatNo() {
        return khewatNo;
    }

    public void setKhewatNo(int khewatNo) {
        this.khewatNo = khewatNo;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public double getPropertyDimension() {
        return propertyDimension;
    }

    public void setPropertyDimension(int propertyDimension) {
        this.propertyDimension = propertyDimension;
    }

    public int getKhatoniNo() {
        return khatoniNo;
    }

    public void setKhatoniNo(int khatoniNo) {
        this.khatoniNo = khatoniNo;
    }

    public String getMozaNo() {
        return mozaNo;
    }

    public void setMozaNo(String mozaNo) {
        this.mozaNo = mozaNo;
    }
}
