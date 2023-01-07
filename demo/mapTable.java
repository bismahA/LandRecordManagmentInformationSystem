package com.example.demo;

public class mapTable {

    int khewatNo;
    int khatoniNo;
    Double propertyDimesnion;
    String propertyType;

    public mapTable(int khewatNo, int khatoniNo, Double propertyDimesnion, String propertyType) {

        this.khewatNo = khewatNo;
        this.khatoniNo = khatoniNo;
        this.propertyDimesnion = propertyDimesnion;
        this.propertyType = propertyType;
    }

    public int getKhewatNo() {
        return khewatNo;
    }

    public void setKhewatNo(int khewatNo) {
        this.khewatNo = khewatNo;
    }

    public int getKhatoniNo() {
        return khatoniNo;
    }

    public void setKhatoniNo(int khatoniNo) {
        this.khatoniNo = khatoniNo;
    }

    public Double getPropertyDimesnion() {
        return propertyDimesnion;
    }

    public void setPropertyDimesnion(Double propertyDimesnion) {
        this.propertyDimesnion = propertyDimesnion;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }
}
