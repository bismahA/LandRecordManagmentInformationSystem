package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class makePaymentHandler {

    araziRecordCenterC controllerObj=new araziRecordCenterC();
    @FXML
    private TextField challanText,fardDocText,cnicText,nameText,ePayText;
    @FXML
    private Label feesText,noPayedText;

    @FXML
    private Button confirmFardButton,payButton,knowFeesButton,homeButton;
    Parent root;
    Stage stage;
    Scene scene;



    public void handleBUttons(ActionEvent event) throws IOException, SQLException {
        if(event.getSource()==confirmFardButton)
        {
            root= FXMLLoader.load(getClass().getResource("confirmFard.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        else if(event.getSource()==payButton)
        {
            String name=nameText.getText();

            String cnicc=cnicText.getText();
            int cnic=Integer.parseInt(cnicc);

            String challa=challanText.getText();
            int challanNo=Integer.parseInt(challa);

            String epay=ePayText.getText();
            int ePayCardNo=Integer.parseInt(epay);

            String fardD=fardDocText.getText();
            int fardDocNo=Integer.parseInt(fardD);

            billDetails bill=new billDetails();
            persistanceHandler phObj=persistanceFactory.getInstance().createPersistanceHandler("db");
            phObj.connectDB();
            bill=phObj.getFardDocFee(fardDocNo);
//
//            String feeL=Integer.toString(fees);
//            feesText.setText(feeL);
            billDetails currentBill=new billDetails(bill.getName(),bill.getCnic(),bill.getFardDocNo(),bill.getFees(),bill.getChallanNumber(),bill.getStatus());
            int transacNo=controllerObj.makePayment(currentBill);

            FXMLLoader loader=new FXMLLoader(getClass().getResource("payed.fxml"));
            Parent root=(Parent) loader.load();
            payedHandler controller=loader.getController();
            controller.setLabel(transacNo);
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();

//            root= FXMLLoader.load(getClass().getResource("payed.fxml"));
//            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            scene=new Scene(root);
//            stage.setScene(scene);
//            stage.show();

        }
        else if(event.getSource()==homeButton)
        {
            root= FXMLLoader.load(getClass().getResource("mainPage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        else if(event.getSource()==knowFeesButton)
        {
//            root= FXMLLoader.load(getClass().getResource("fard.fxml"));
//            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            scene=new Scene(root);
//            stage.setScene(scene);
//            stage.show();

            String name=nameText.getText();

            String cnicc=cnicText.getText();
            int cnic=Integer.parseInt(cnicc);

            String challa=challanText.getText();
            int challanNo=Integer.parseInt(challa);

            String epay=ePayText.getText();
            int ePayCardNo=Integer.parseInt(epay);

            String fardD=fardDocText.getText();
            int fardDocNo=Integer.parseInt(fardD);

            persistanceHandler phObj=persistanceFactory.getInstance().createPersistanceHandler("db");
            phObj.connectDB();
            billDetails bill=new billDetails();
            bill=phObj.getFardDocFee(fardDocNo);

            String feeL=Integer.toString(bill.getFees());
            feesText.setText(feeL);
            noPayedText.setText(bill.getStatus());









        }
    }

}
