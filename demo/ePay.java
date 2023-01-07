package com.example.demo;

public class ePay {

    int called=0;
    public ePay() {
        called=1;
    }

    public String payBill(billDetails bill)
    {
        String status="";
        if(called==1)
        {
            status="paid";
        }
        else
        {
            status="not paid";
        }
         return status;
    }
}
