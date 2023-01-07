package com.example.demo;

public class transactionedBills {

    billDetails bill;
    int transactionNo;

    public transactionedBills(billDetails bill, int transactionNo) {
        this.bill = bill;
        this.transactionNo = transactionNo;
    }

    public transactionedBills() {

    }

    public billDetails getBill() {
        return bill;
    }

    public void setBill(billDetails bill) {
        this.bill = bill;
    }

    public int getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(int transactionNo) {
        this.transactionNo = transactionNo;
    }
}
