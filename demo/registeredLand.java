package com.example.demo;

import java.sql.SQLException;
import java.util.ArrayList;

public class registeredLand {

    public void addNewLand(landDetails land) throws SQLException {
        addLandRequest reqObj=new addLandRequest(land);
        persistanceHandler phObj=persistanceFactory.getInstance().createPersistanceHandler("db");
        phObj.connectDB();
        phObj.saveLandRecord(reqObj);

    }

    public ArrayList<landDetails> searchLand(String mozaNo)
    {


        ArrayList<landDetails> found=new ArrayList<>();
        persistanceHandler phObj=persistanceFactory.getInstance().createPersistanceHandler("db");
        phObj.connectDB();
        found=phObj.getLandRecord(mozaNo);
        return found;
    }

    public int createFardForLand(landDetails land) throws SQLException {

        fard fardObj=new fard(land);
       int fardDocNo= fardObj.createDoc();
       return fardDocNo;
    }

    public String fetchMapForLand(mapTable mapInfo)
    {
        String map="";
        persistanceHandler phObj=persistanceFactory.getInstance().createPersistanceHandler("db");
        phObj.connectDB();
        landDetails land=phObj.getLandRecordForMap(mapInfo);
        mapRequest mr=new mapRequest(land);
        map=mr.generateMap();
        return map;
    }
}
