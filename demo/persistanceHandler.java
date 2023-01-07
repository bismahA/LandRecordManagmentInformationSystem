package com.example.demo;

import java.sql.SQLException;
import java.util.ArrayList;

public interface persistanceHandler {
    abstract void connectDB();
    abstract void saveLandRecord(addLandRequest obj) throws SQLException;
    abstract void updateLandRecord() throws SQLException;
    abstract void deleteLandRecord() throws SQLException;
    abstract ArrayList<landDetails> getLandRecord(String mozaNo);

    landDetails getLandRecordForFard(fardTable record);

    void saveFardRequestRecord(fardRequestData record) throws SQLException;

    int getFixAmount(String district);

    fardRequestData getFardRecord(int fardDocNo);

    void saveBill(billDetails bill) throws SQLException;

    billDetails getFardDocFee(int fardDocNo);

    void savePayedBill(billDetails bill) throws SQLException;

    void saveTransactionedBill(transactionedBills bill) throws SQLException;

    transactionedBills getBillForFardReceival(int transactionNo);

    landDetails getLandRecordForMap(mapTable mapInfo);
}
