package com.example.demo;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class dbHandler implements persistanceHandler{


    Connection con=null;
    @Override
    public void connectDB() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
            if(con == null) {
                System.out.println("DB connection failed");}
            else
                System.out.println("DB connection successful");

        }
        catch(Exception e) {
            System.out.println("exception: "+e);
        }
    }

    @Override
    public void saveLandRecord(addLandRequest obj) throws SQLException {

        String sql = "INSERT INTO registeredland (khataNumber,recordNumber,name,guardianName,guardianRelation,cnic,city,district,currentAddress,permanentAddress,ownerName,kashtKarName,khewatNo,propertyType,propertyDimension,khatoniNo,mozaNo) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?,?)";
        PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
        statement.setInt(1,obj.land.registryInfo.getKhataNo());
        statement.setInt(2, obj.land.registryInfo.getKhataNo());
        statement.setString(3,obj.land.personalInfo.getName());;
        statement.setString(4, obj.land.personalInfo.getGuardianName());
        statement.setString(5, obj.land.personalInfo.getGuardianRelation());
        statement.setInt(6, obj.land.personalInfo.getCnic());
        statement.setString(7, obj.land.personalInfo.getCity());
        statement.setString(8, obj.land.personalInfo.getDistrict());
        statement.setString(9, obj.land.personalInfo.getCurrentAddress());
        statement.setString(10, obj.land.personalInfo.getPermanenetAddress());
        statement.setString(11,obj.land.propertyInfo.getOwnerName());
        statement.setString(12,obj.land.propertyInfo.getKashtKarName());
        statement.setInt(13,obj.land.propertyInfo.getKhewatNo());
        statement.setString(14,obj.land.propertyInfo.getPropertyType());
        statement.setDouble(15,obj.land.propertyInfo.getPropertyDimension());
        statement.setInt(16,obj.land.propertyInfo.getKhatoniNo());
        statement.setString(17,obj.land.propertyInfo.getMozaNo());

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
        }


    }

    @Override
    public void updateLandRecord() throws SQLException {

    }

    @Override
    public void deleteLandRecord() throws SQLException {

    }

    @Override
    public ArrayList<landDetails> getLandRecord(String mozaNo) {

        ArrayList<landDetails> foundLands=new ArrayList<>();
        Statement stmt;
        try {
            stmt = (Statement) con.createStatement();
            String sql="Select * from registeredland where mozaNo='"+mozaNo+"'";
            ResultSet rs= stmt.executeQuery(sql);
            while(rs.next())
            {
                registeredDetails rd=new registeredDetails(rs.getInt(1),rs.getInt(2));
                personalDetails pd=new personalDetails(rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
                propertyDetails prd=new propertyDetails(rs.getString(11),rs.getString(12),rs.getInt(13),rs.getString(14),rs.getDouble(15),rs.getInt(16),rs.getString(17));
                landDetails ld=new landDetails(rd,pd,prd);
                foundLands.add(ld);
            }
            con.close();
        }
        catch (SQLException e) {

            System.out.println("exception: "+e);
        }
        return foundLands;
    }

    @Override
    public landDetails getLandRecordForFard(fardTable record) {

        landDetails fardRecord=new landDetails();
        Statement stmt;
        try {
            stmt = (Statement) con.createStatement();
            String sql="Select * from registeredland where cnic='"+record.getCnic()+"' and khewatNo='"+record.getKhewat()+"' and khatoniNo='"+record.getKhatnoi()+"' and ownerName='"+record.getName()+"'";
            ResultSet rs= stmt.executeQuery(sql);
            while(rs.next())
            {
                registeredDetails rd=new registeredDetails(rs.getInt(1),rs.getInt(2));
                personalDetails pd=new personalDetails(rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
                propertyDetails prd=new propertyDetails(rs.getString(11),rs.getString(12),rs.getInt(13),rs.getString(14),rs.getDouble(15),rs.getInt(16),rs.getString(17));
                 fardRecord=new landDetails(rd,pd,prd);
               // foundLands.add(ld);
            }
            con.close();
        }
        catch (SQLException e) {

            System.out.println("exception: "+e);
        }
        return fardRecord;
    }

    @Override
    public void saveFardRequestRecord(fardRequestData record) throws SQLException {

        String sql = "INSERT INTO fardrequestdata (khataNumber,recordNumber,name,guardianName,guaurdianRelation,cnic,city,district,currentAddress,permanentAddress,ownerName,kashtKarName,khewatNo,propertyType,propertyDimension,khatoniNo,mozaNo,fardDocNo) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?,?,?)";
        PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
        statement.setInt(1,record.land.registryInfo.getKhataNo());
        statement.setInt(2, record.land.registryInfo.getKhataNo());
        statement.setString(3,record.land.personalInfo.getName());;
        statement.setString(4, record.land.personalInfo.getGuardianName());
        statement.setString(5, record.land.personalInfo.getGuardianRelation());
        statement.setInt(6, record.land.personalInfo.getCnic());
        statement.setString(7, record.land.personalInfo.getCity());
        statement.setString(8, record.land.personalInfo.getDistrict());
        statement.setString(9, record.land.personalInfo.getCurrentAddress());
        statement.setString(10, record.land.personalInfo.getPermanenetAddress());
        statement.setString(11,record.land.propertyInfo.getOwnerName());
        statement.setString(12,record.land.propertyInfo.getKashtKarName());
        statement.setInt(13,record.land.propertyInfo.getKhewatNo());
        statement.setString(14,record.land.propertyInfo.getPropertyType());
        statement.setDouble(15,record.land.propertyInfo.getPropertyDimension());
        statement.setInt(16,record.land.propertyInfo.getKhatoniNo());
        statement.setString(17,record.land.propertyInfo.getMozaNo());
        statement.setInt(18,record.getFardDocNo());


        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
        }


    }

    @Override
    public int getFixAmount(String district) {

        int amount=0;
        Statement stmt;
        try {
            stmt = (Statement) con.createStatement();
            String sql="Select * from paymentpolicytable where district='"+district+"'";
            ResultSet rs= stmt.executeQuery(sql);
            while(rs.next())
            {
                amount=rs.getInt(2);

                // foundLands.add(ld);
            }
            con.close();
        }
        catch (SQLException e) {

            System.out.println("exception: "+e);
        }
        return amount;
    }

    @Override
    public fardRequestData getFardRecord(int fardDocNo) {

        fardRequestData fardRecord=new fardRequestData();
        Statement stmt;
        try {
            stmt = (Statement) con.createStatement();
            String sql="Select * from fardrequestdata where fardDocNo='"+fardDocNo+"'";
            ResultSet rs= stmt.executeQuery(sql);
            while(rs.next())
            {
                registeredDetails rd=new registeredDetails(rs.getInt(1),rs.getInt(2));
                personalDetails pd=new personalDetails(rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
                propertyDetails prd=new propertyDetails(rs.getString(11),rs.getString(12),rs.getInt(13),rs.getString(14),rs.getDouble(15),rs.getInt(16),rs.getString(17));
                int fardDocno1=rs.getInt(18);
                landDetails land=new landDetails(rd,pd,prd);
                fardRecord=new fardRequestData(fardDocno1,land);
                // foundLands.add(ld);
            }
            con.close();
        }
        catch (SQLException e) {

            System.out.println("exception: "+e);
        }
        return fardRecord;
    }

    @Override
    public void saveBill(billDetails bill) throws SQLException {

        String sql = "INSERT INTO billstable (name,cnic,fardDocNo,fees,challanNo,status) VALUES (?, ?, ?, ?, ?,?)";
        PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
        statement.setString(1,bill.getName());;
        statement.setInt(2, bill.getCnic());
        statement.setInt(3, bill.getFardDocNo());
        statement.setInt(4, bill.getFees());
        statement.setInt(5, bill.getChallanNumber());
        statement.setString(6,bill.getStatus());;



        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
        }


    }

    @Override
    public billDetails getFardDocFee(int fardDocNo) {

       billDetails bill=new billDetails();
        Statement stmt;
        try {
            stmt = (Statement) con.createStatement();
            String sql="Select * from billstable where fardDocNo='"+fardDocNo+"'";
            ResultSet rs= stmt.executeQuery(sql);
            while(rs.next())
            {
                 bill=new billDetails(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getString(6));
               // fees=rs.getInt(4);
                // foundLands.add(ld);
            }
            con.close();
        }
        catch (SQLException e) {

            System.out.println("exception: "+e);
        }
        return bill;
    }

    @Override
    public void savePayedBill(billDetails bill) throws SQLException {

        String sql = "INSERT INTO payedBill (name,cnic,fardDocNo,fees,challanNo,status) VALUES (?, ?,?,?,?,?)";
        PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);

        statement.setString(1,bill.getName());
        statement.setInt(2, bill.getCnic());
        statement.setInt(3,bill.getFardDocNo());;
        statement.setInt(4,bill.getFees());
        statement.setInt(5,bill.getChallanNumber());
        statement.setString(6,bill.getStatus());


        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
        }


    }

    @Override
    public void saveTransactionedBill(transactionedBills bill) throws SQLException {

        String sql = "INSERT INTO transactioned (name,cnic,fardDocNo,fees,challanNo,status,transactionNo) VALUES (?, ?,?,?,?,?,?)";
        PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
        statement.setString(1,bill.bill.getName());;
        statement.setInt(2, bill.bill.getCnic());
         statement.setInt(3,bill.bill.getFardDocNo());
        statement.setInt(4,bill.bill.getFees());
        statement.setInt(5,bill.bill.getChallanNumber());
        statement.setString(6,bill.bill.getStatus());
        statement.setInt(7,bill.getTransactionNo());

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
        }


    }

    @Override
    public transactionedBills getBillForFardReceival(int transactionNo) {

        transactionedBills bill=new transactionedBills();
        Statement stmt;
        try {
            stmt = (Statement) con.createStatement();
            String sql="Select * from transactioned where transactionNo='"+transactionNo+"'";
            ResultSet rs= stmt.executeQuery(sql);
            while(rs.next())
            {
                bill=new transactionedBills(new billDetails(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getString(6)),rs.getInt(7));
                // fees=rs.getInt(4);
                // foundLands.add(ld);
            }
            con.close();
        }
        catch (SQLException e) {

            System.out.println("exception: "+e);
        }
        return bill;
    }

    @Override
    public landDetails getLandRecordForMap(mapTable mapInfo) {

        landDetails mapRequest=new landDetails();
        Statement stmt;
        try {
            stmt = (Statement) con.createStatement();
            String sql="Select * from registeredland where khewatNo='"+mapInfo.getKhewatNo()+"' and khatoniNo='"+mapInfo.getKhatoniNo()+"' and propertyDimension='"+mapInfo.getPropertyDimesnion()+"' and propertyType='"+mapInfo.getPropertyType()+"'";
            ResultSet rs= stmt.executeQuery(sql);
            while(rs.next())
            {
                registeredDetails rd=new registeredDetails(rs.getInt(1),rs.getInt(2));
                personalDetails pd=new personalDetails(rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
                propertyDetails prd=new propertyDetails(rs.getString(11),rs.getString(12),rs.getInt(13),rs.getString(14),rs.getDouble(15),rs.getInt(16),rs.getString(17));
                mapRequest=new landDetails(rd,pd,prd);
                // foundLands.add(ld);
            }
            con.close();
        }
        catch (SQLException e) {

            System.out.println("exception: "+e);
        }
        return mapRequest;
    }



}
