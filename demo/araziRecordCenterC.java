package com.example.demo;

import java.sql.SQLException;
import java.util.ArrayList;

public class araziRecordCenterC {

    registeredLand regLandObj=new registeredLand();

    public void createNewRecord(landDetails land) throws SQLException {
        regLandObj.addNewLand(land);
    }

    public ArrayList<landDetails> enterLandDetails(String mozaNo)
    {

        ArrayList<landDetails> found=new ArrayList<>();
        found=regLandObj.searchLand(mozaNo);
        return found;
    }

    public int selectDesiredLand(landDetails land) throws SQLException {

        int fardDocNo=regLandObj.createFardForLand(land);
        return fardDocNo;

    }

    public billDetails knowPayment(int fardDocNo) throws SQLException {
        fardRequest obj=new fardRequest();
        fardRequestData fard=obj.getFard(fardDocNo);
        billDetails bill=obj.generateBill(fard);
        return bill;

    }

    public int makePayment(billDetails bill) throws SQLException {
        ePay obj=new ePay();
        String status=obj.payBill(bill);

        billDetails payed=new billDetails(bill.getName(), bill.getCnic(),bill.getFardDocNo(),bill.getFees(),bill.getChallanNumber(),status);
        persistanceHandler phObj=persistanceFactory.getInstance().createPersistanceHandler("db");
        phObj.connectDB();
        phObj.savePayedBill(payed);

        billRequest br=new billRequest(payed);
        int transactionNo=br.verifyBillPayment();

        transactionedBills transacBill=new transactionedBills(payed,transactionNo);
        phObj.saveTransactionedBill(transacBill);

        return transacBill.getTransactionNo();

    }

    public fardRequestData receiveFard(int transacNo)
    {
        persistanceHandler phObj=persistanceFactory.getInstance().createPersistanceHandler("db");
        phObj.connectDB();
        transactionedBills bill=phObj.getBillForFardReceival(transacNo);

        billRequest br=new billRequest(bill);
        String status=br.getBillPaymentStatus();

        fardRequest fr=new fardRequest();
        fardRequestData fard=new fardRequestData();
        if(status=="paid")
        {
            fard=fr.getGeneratedFard(bill.bill.getFardDocNo());
        }
        else
        {
            System.out.println("status is not paid you cannot receive Fard");
        }

        return fard;
    }

    public String selectDesiredLand(mapTable mapInfo)
    {

        registeredLand rl=new registeredLand();
        String map=rl.fetchMapForLand(mapInfo);
        return map;
    }
}
