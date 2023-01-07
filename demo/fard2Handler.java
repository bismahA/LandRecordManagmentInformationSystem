package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class fard2Handler {

    ArrayList<landDetails> array=new ArrayList<>();
    @FXML
    private Label tehsilLabel;
    @FXML
    private Label mozaLabel;
    @FXML
    private Label districtLabel;

    @FXML
    private Label cnicLabel;
    public static Label staticLabel;
    @FXML
    private Button homeButton;
    Parent root;
    Stage stage;
    Scene scene;


    public fard2Handler(ArrayList<landDetails> array) {
        this.array = array;
    }
//    public void handle() {
//
//        System.out.println(found.get(1).personalInfo.getCity());
//        tehsilLabel.setText(found.get(1).personalInfo.getCity());
//        mozaLabel.setText(found.get(1).propertyInfo.getMozaNo());
//        districtLabel.setText(found.get(1).personalInfo.getDistrict());
//        int cnic=found.get(1).personalInfo.getCnic();
//        String cnicc=Integer.toString(cnic);
//        cnicLabel.setText(cnicc);
//    }




    //@Override
   // public void initialize(URL url, ResourceBundle resourceBundle) {
//        tehsilLabel.setText(found.get(1).personalInfo.getCity());
//        mozaLabel.setText(found.get(1).propertyInfo.getMozaNo());
//        districtLabel.setText(found.get(1).personalInfo.getDistrict());
//        int cnic=found.get(1).personalInfo.getCnic();
//        String cnicc=Integer.toString(cnic);
//        cnicLabel.setText(cnicc);
//      //  System.out.println(found.get(1).getPersonalInfo().getGuardianRelation()+"----------");
//

      //  handle();
//        //staticLabel=districtLabel;
   // }
    @FXML
    public void handleBUttons(ActionEvent event) throws IOException {

        if (event.getSource() == homeButton) {
            root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
    }
}
