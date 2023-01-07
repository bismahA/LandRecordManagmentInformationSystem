package com.example.demo;

public class personalDetails {
    String name;
    String guardianName;
    String guardianRelation;
    int cnic;
    String city;
    String district;
    String currentAddress;
    String permanenetAddress;

    public personalDetails(String name, String guardianName, String guardianRelation, int cnic, String city, String district, String currentAddress, String permanenetAddress) {
        this.name = name;
        this.guardianName = guardianName;
        this.guardianRelation = guardianRelation;
        this.cnic = cnic;
        this.city = city;
        this.district = district;
        this.currentAddress = currentAddress;
        this.permanenetAddress = permanenetAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianRelation() {
        return guardianRelation;
    }

    public void setGuardianRelation(String guardianRelation) {
        this.guardianRelation = guardianRelation;
    }

    public int getCnic() {
        return cnic;
    }

    public void setCnic(int cnic) {
        this.cnic = cnic;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getPermanenetAddress() {
        return permanenetAddress;
    }

    public void setPermanenetAddress(String permanenetAddress) {
        this.permanenetAddress = permanenetAddress;
    }
}
