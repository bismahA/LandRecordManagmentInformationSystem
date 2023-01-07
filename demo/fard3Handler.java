package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class fard3Handler {

    @FXML
    private Label challanNumberLabel,cnicLabel,fardDocNoLabel,feesLabel,khewatLabel,nameLabel,khatoniLabel;

    @FXML
    private Button confirmFardButton,fard2Button,firstFardButton,homeButton;
    Parent root;
    Stage stage;
    Scene scene;


    public void setLabels(billDetails bill,landDetails land)
    {
        int chL=bill.getChallanNumber();
      //  System.out.println(chL);
        String challan=Integer.toString(chL);
      //  System.out.println(challan);
        challanNumberLabel.setText(challan);
       // System.out.println(challanNumberLabel);

        int cnicc=land.personalInfo.getCnic();
        String cnic=Integer.toString(cnicc);
        cnicLabel.setText(cnic);

        int fardD=bill.getFardDocNo();
        String fardDocNo=Integer.toString(fardD);
        fardDocNoLabel.setText(fardDocNo);

        int fee=bill.getFees();
        String fees=Integer.toString(fee);
        feesLabel.setText(fees);

        int khew=land.propertyInfo.getKhewatNo();
        String khewatNo=Integer.toString(khew);
        khewatLabel.setText(khewatNo);

        nameLabel.setText(land.propertyInfo.getOwnerName());

        int khato=land.propertyInfo.getKhatoniNo();
        String khatoniNo=Integer.toString(khato);
        khatoniLabel.setText(khatoniNo);


    }

    public void handleBUttons(ActionEvent event) throws IOException {

        if(event.getSource()==confirmFardButton)
        {
            root= FXMLLoader.load(getClass().getResource("confirmFard.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        else if(event.getSource()==fard2Button)
        {
            root= FXMLLoader.load(getClass().getResource("fard2.fxml"));
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
        else if(event.getSource()==firstFardButton)
        {
            root= FXMLLoader.load(getClass().getResource("fard.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
    }
}
