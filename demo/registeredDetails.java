package com.example.demo;

public class registeredDetails {
    int khataNo;
    int recordNo;

    public registeredDetails(int khataNo, int recordNo) {
        this.khataNo = khataNo;
        this.recordNo = recordNo;
    }

    public int getKhataNo() {
        return khataNo;
    }

    public void setKhataNo(int khataNo) {
        this.khataNo = khataNo;
    }

    public int getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(int recordNo) {
        this.recordNo = recordNo;
    }
}
