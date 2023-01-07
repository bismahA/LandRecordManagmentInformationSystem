package com.example.demo;

import java.sql.SQLException;

public class fard {

    landDetails land;

    public fard(landDetails land) {
        this.land = land;
    }

    public landDetails getLand() {
        return land;
    }

    public void setLand(landDetails land) {
        this.land = land;
    }


    public int createDoc() throws SQLException {

        fardRequest fardRObj=new fardRequest(land);
        int fardDocNo=fardRObj.generateFard();
        return fardDocNo;
    }
}
