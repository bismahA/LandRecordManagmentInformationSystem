package com.example.demo;

import java.util.Random;

public class billRequest {

    billDetails payed;
    transactionedBills bill;

    public billRequest(transactionedBills bill) {
        this.bill = bill;
    }

    public transactionedBills getBill() {
        return bill;
    }

    public void setBill(transactionedBills bill) {
        this.bill = bill;
    }

    Random rand = new Random(); //instance of random class
    int upperbound = 1001;

    public billRequest(billDetails payed) {
        this.payed = payed;
    }

    public billDetails getPayed() {
        return payed;
    }

    public void setPayed(billDetails payed) {
        this.payed = payed;
    }
    public String getPaidStatus()
    {
        String status="";
        if(payed.getStatus()=="paid")
        {
            status="paid";
        }
        else
        {
            status="not paid";
        }
        return status;
    }

    public String getBillPaymentStatus()
    {
        String status="";
        if(bill.bill.getStatus()=="paid")
        {
            status="paid";
        }
        else
        {
            status="not paid";
        }
        return status;
    }

    public int verifyBillPayment()
    {
        int transactionNo=0;

        String status=getPaidStatus();
       // if(status=="paid")
        //{
            transactionNo = rand.nextInt(upperbound);
        //}
        //else
        //{
         // transactionNo=0;
        //}
        return transactionNo;

    }
}
