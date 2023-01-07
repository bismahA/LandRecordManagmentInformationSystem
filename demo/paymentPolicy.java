package com.example.demo;

public class paymentPolicy {

    public int getAmount(String district)
    {


      //  payment obj=new payment();
        persistanceHandler phObj=persistanceFactory.getInstance().createPersistanceHandler("db");
        phObj.connectDB();
        int amount=phObj.getFixAmount(district);

        return amount;
    }
}
