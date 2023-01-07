package com.example.demo;

public class fardTable {

    String name;
    int khatnoi;
    int khewat;
    int cnic;

    public fardTable(String name, int khatnoi, int khewat, int cnic) {
        this.name = name;
        this.khatnoi = khatnoi;
        this.khewat = khewat;
        this.cnic = cnic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKhatnoi() {
        return khatnoi;
    }

    public void setKhatnoi(int khatnoi) {
        this.khatnoi = khatnoi;
    }

    public int getKhewat() {
        return khewat;
    }

    public void setKhewat(int khewat) {
        this.khewat = khewat;
    }

    public int getCnic() {
        return cnic;
    }

    public void setCnic(int cnic) {
        this.cnic = cnic;
    }
}
