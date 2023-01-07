package com.example.demo;

public class billDetails {

    String name;
    int cnic;
    int fardDocNo;
    int fees;
    int challanNumber;
    String status;

    public billDetails() {
    }

    public billDetails(String name, int cnic, int fardDocNo, int fees, int challanNumber, String status) {
        this.name = name;
        this.cnic = cnic;
        this.fardDocNo = fardDocNo;
        this.fees = fees;
        this.challanNumber = challanNumber;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCnic() {
        return cnic;
    }

    public void setCnic(int cnic) {
        this.cnic = cnic;
    }

    public int getFardDocNo() {
        return fardDocNo;
    }

    public void setFardDocNo(int fardDocNo) {
        this.fardDocNo = fardDocNo;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public int getChallanNumber() {
        return challanNumber;
    }

    public void setChallanNumber(int challanNumber) {
        this.challanNumber = challanNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
