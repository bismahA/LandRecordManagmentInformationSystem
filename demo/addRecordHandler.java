package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class addRecordHandler implements Initializable {
    araziRecordCenterC controllerObj=new araziRecordCenterC();
    @FXML
    private AnchorPane slider,pane1;
    @FXML
    private Label menu,menuBack;
    @FXML
    private ImageView menuLogo1;
    @FXML
    private TextField GuardianName,Khatoni,name,RecordNumber,cnic,currentAddress,kashtKarName,
            khataNumber,khewatNumber,mozaNo,permananetAddress,propertyDimesnions,jugarC,jugarD,jugarGr,jugarPt,OwnerName;
    @FXML
    private ChoiceBox<String> guardianRelationListt;
    private String[] rList={"enter relation","father","mother","wife","husband",
            "widow","daughter","son"};
    @FXML
    private ChoiceBox<String>cityList;
    private String[] cList={"enter city","attock","islamabad","okara","bhawalpur","bhawalnagar","bakhar",
            "pakpattan","toba taik singh","jhelum","jhang","chakwal","chiniot","hafizabad","khanaywal","khushab","dera ghazi khan","rajanpur",
            "rawalpindi","rahim yar khan","sahiwal","sargodha","sialkot","sheikhupura","faislabad","kasor","gujraat","gujrawala","lahore",
            "lodrah","layyah","muzafargarh","multan","mandi bahauddin","mianwalli","narowall","nankana sahib","wihari"};
    @FXML
    private ChoiceBox<String>districtListt;
    private String[] dList={"enter district","attock","islamabad","okara","bhawalpur","bhawalnagar","bakhar",
            "pakpattan","toba taik singh","jhelum","jhang","chakwal","chiniot","hafizabad","khanaywal","khushab","dera ghazi khan","rajanpur",
            "rawalpindi","rahim yar khan","sahiwal","sargodha","sialkot","sheikhupura","faislabad","kasor","gujraat","gujrawala","lahore",
            "lodrah","layyah","muzafargarh","multan","mandi bahauddin","mianwalli","narowall","nankana sahib","wihari"};
    @FXML
    private ChoiceBox<String>propertyTypeList;
    private String[] pList={"enter type","residential","commercial","industrial",
            "agricultral", "vacant"};
//    ObservableList<String> districtList= FXCollections.observableArrayList("enter district","attock","islamabad","okara","bhawalpur","bhawalnagar","bakhar",
//            "pakpattan","toba taik singh","jhelum","jhang","chakwal","chiniot","hafizabad","khanaywal","khushab","dera ghazi khan","rajanpur",
//            "rawalpindi","rahim yar khan","sahiwal","sargodha","sialkot","sheikhupura","faislabad","kasor","gujraat","gujrawala","lahore",
//            "lodrah","layyah","muzafargarh","multan","mandi bahauddin","mianwalli","narowall","nankana sahib","wihari");
//
//    ObservableList<String> guardianRelationList= FXCollections.observableArrayList("enter relation","father","mother","wife","husband",
//            "widow","daughter","son");
//    ObservableList<String> cityList= FXCollections.observableArrayList("enter city","attock","islamabad","okara","bhawalpur","bhawalnagar","bakhar",
//            "pakpattan","toba taik singh","jhelum","jhang","chakwal","chiniot","hafizabad","khanaywal","khushab","dera ghazi khan","rajanpur",
//            "rawalpindi","rahim yar khan","sahiwal","sargodha","sialkot","sheikhupura","faislabad","kasor","gujraat","gujrawala","lahore",
//            "lodrah","layyah","muzafargarh","multan","mandi bahauddin","mianwalli","narowall","nankana sahib","wihari");
//
//    ObservableList<String> propertyTypeList= FXCollections.observableArrayList("enter type","residential","commercial","industrial",
//            "agricultral", "vacant");
    @FXML
    private Button addButton,homeButton;
    Parent root;
    Stage stage;
    Scene scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        districtListt.setValue("enter district");
//        districtListt.getItems().addAll(dList);
//
//        guardianRelationListt.setValue("enter relation");
//        guardianRelationListt.getItems().addAll(rList);
//
//        cityList.setValue("enter city");
//        cityList.getItems().addAll(cList);
//
//        propertyTypeList.setValue("select type");
//        propertyTypeList.getItems().addAll(pList);
    }


    public void addRecordButton(ActionEvent event) throws IOException, SQLException {
        if(event.getSource()==addButton)
        {
            String namee=name.getText();
            String guardianName=GuardianName.getText();
           // String guardianRelation= (String) guardianRelationListt.getValue();
            String guardianRelation=jugarGr.getText();
            String cnicj= cnic.getText();
            //String citys= (String) cityList.getValue();
            String citys=jugarC.getText();
            String currAddress=currentAddress.getText();
            String perAddress=permananetAddress.getText();
            String khataNo= khataNumber.getText();
            //String dis= (String) districtListt.getValue();
            String dis=jugarD.getText();
            String recNo= RecordNumber.getText();
            String ownerN=OwnerName.getText();
            String kashtKarN=kashtKarName.getText();
            String khewatNo=khewatNumber.getText();
            //String propType= (String) propertyTypeList.getValue();
            String propType=jugarPt.getText();
            String propDim= propertyDimesnions.getText();
            String khatoniNo=Khatoni.getText();
            String moza=mozaNo.getText();

            int khataNos=Integer.parseInt(khataNo);
            int recNos=Integer.parseInt(recNo);
            int cnicNo=Integer.parseInt(cnicj);
            int khewatNos=Integer.parseInt(khewatNo);
            double propDs=Double.parseDouble(propDim);
            int khatoniNos=Integer.parseInt(khatoniNo);

            registeredDetails rd=new registeredDetails(khataNos,recNos);
            personalDetails pd=new personalDetails(namee,guardianName,guardianRelation,cnicNo,citys,dis,currAddress,perAddress);
            propertyDetails prd=new propertyDetails(ownerN,kashtKarN,khewatNos,propType,propDs,khatoniNos,moza);

            landDetails ld=new landDetails(rd,pd,prd);

            controllerObj.createNewRecord(ld);



            root= FXMLLoader.load(getClass().getResource("addRecordMessage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        else if(event.getSource()==homeButton)
        {
            root= FXMLLoader.load(getClass().getResource("mainPage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }


//        //these values will be sent in business logic layer to add be saved
//
//        registerMessageLabel.setText("NEW RECORD HAS BEEN REGISTERED AND ADDED");
    }



}