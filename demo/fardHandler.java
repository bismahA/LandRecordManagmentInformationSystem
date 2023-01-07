package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;

public class fardHandler {

    araziRecordCenterC controllerObj=new araziRecordCenterC();
    ObservableList<String> guardianRelationList= FXCollections.observableArrayList("enter relation","father","mother","wife","husband",
            "widow","daughter","son");
    ObservableList<String> districtList=FXCollections.observableArrayList("enter district","attock","islamabad","okara","bhawalpur","bhawalnagar","bakhar",
            "pakpattan","toba taik singh","jhelum","jhang","chakwal","chiniot","hafizabad","khanaywal","khushab","dera ghazi khan","rajanpur",
            "rawalpindi","rahim yar khan","sahiwal","sargodha","sialkot","sheikhupura","faislabad","kasor","gujraat","gujrawala","lahore",
            "lodrah","layyah","muzafargarh","multan","mandi bahauddin","mianwalli","narowall","nankana sahib","wihari");

    @FXML
    private ChoiceBox relationList;

    @FXML
    private ChoiceBox districttList;
    @FXML
    private Button fard1Button,fardButton,homeButton,lastFardButton;
    Parent root;
    Stage stage;
    Scene scene;


    @FXML
    private void initialize()
    {
       // relationList.setValue("enter relation");
        //relationList.getItems().addAll(guardianRelationList);

        //districttList.setValue("enter district");
      //  districttList.setItems(districtList);

    }

    @FXML
    public void handleBUttons(ActionEvent event) throws IOException {

        if(event.getSource()==fard1Button)
        {



            root= FXMLLoader.load(getClass().getResource("fard1.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();


        }


        else if (event.getSource() == homeButton)
        {
            root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        else if(event.getSource()==lastFardButton)
        {

            root= FXMLLoader.load(getClass().getResource("fard3.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        }


    }
}
