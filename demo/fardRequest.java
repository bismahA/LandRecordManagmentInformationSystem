package com.example.demo;

import java.sql.SQLException;
import java.util.Random;

public class fardRequest {

    landDetails land;
    Random rand = new Random(); //instance of random class
    int upperbound = 1001;

    public fardRequest() {
    }

    public fardRequest(landDetails land) {
        this.land = land;
    }

    public landDetails getLand() {
        return land;
    }

    public void setLand(landDetails land) {
        this.land = land;
    }

    public int generateFard() throws SQLException {
        int fardDocNumber = rand.nextInt(upperbound);
        fardRequestData fardRecord=new fardRequestData(fardDocNumber,land);
        persistanceHandler phObj=persistanceFactory.getInstance().createPersistanceHandler("db");
        phObj.connectDB();
        phObj.saveFardRequestRecord(fardRecord);
        System.out.println(fardRecord);
        return fardDocNumber;

        //save in db then return the serial no
    }

    public fardRequestData getFard(int fardDocNo)
    {

        persistanceHandler phObj=persistanceFactory.getInstance().createPersistanceHandler("db");
        phObj.connectDB();
        fardRequestData fardRecord=phObj.getFardRecord(fardDocNo);
        return fardRecord;
    }

    public billDetails generateBill(fardRequestData fard) throws SQLException {

        paymentPolicy obj1=new paymentPolicy();
        payment obj2=new payment();
        int amount= obj1.getAmount(fard.land.personalInfo.getDistrict());
        int fees= obj2.calculatePayemnt(amount);
        int challanNo = rand.nextInt(upperbound);


        String status="not paid";
        billDetails bill=new billDetails(fard.land.personalInfo.getName(),fard.land.personalInfo.getCnic(),fard.getFardDocNo(),fees,challanNo,status);
        persistanceHandler phObj=persistanceFactory.getInstance().createPersistanceHandler("db");
        phObj.connectDB();
        phObj.saveBill(bill);
        return bill;
    }

    public fardRequestData getGeneratedFard(int fardDocNo)
    {
        persistanceHandler phObj=persistanceFactory.getInstance().createPersistanceHandler("db");
        phObj.connectDB();
        fardRequestData fard=phObj.getFardRecord(fardDocNo);
        return fard;
    }
}
