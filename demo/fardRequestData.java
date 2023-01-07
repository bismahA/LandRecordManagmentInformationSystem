package com.example.demo;

public class fardRequestData {
    int fardDocNo;
    landDetails land;

    public fardRequestData() {
    }

    public fardRequestData(int fardDocNo, landDetails land) {
        this.fardDocNo = fardDocNo;
        this.land = land;
    }

    public int getFardDocNo() {
        return fardDocNo;
    }

    public void setFardDocNo(int fardDocNo) {
        this.fardDocNo = fardDocNo;
    }

    public landDetails getLand() {
        return land;
    }

    public void setLand(landDetails land) {
        this.land = land;
    }
}
