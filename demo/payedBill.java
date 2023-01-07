package com.example.demo;

public class payedBill {

    int fardDocNo;
    String status;
    int challanNo;

    public payedBill(int fardDocNo, String status, int challanNo) {

        this.fardDocNo = fardDocNo;
        this.status = status;
        this.challanNo = challanNo;
    }

    public int getFardDocNo() {
        return fardDocNo;
    }

    public void setFardDocNo(int fardDocNo) {
        this.fardDocNo = fardDocNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getChallanNo() {
        return challanNo;
    }

    public void setChallanNo(int challanNo) {
        this.challanNo = challanNo;
    }
}
