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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class printfFardHandler implements Initializable {

    @FXML
    private TextField transacText;
    @FXML
    private Button verifyStatus;
    @FXML
    private Button printButton;
    @FXML
    private Button downloadButton;
    @FXML
    private Label setActionLabel;

    @FXML
    private Label message1;

    @FXML
    private Label message2;
    Parent root;
    Stage stage;
    Scene scene;
    @FXML
    private Button homeButton;
    @FXML
    private Button confirmPayButton;

    araziRecordCenterC controllerObj=new araziRecordCenterC();

    public void handleBUttons(ActionEvent event) throws IOException, SQLException {

        if (event.getSource() == verifyStatus) {

            String trans=transacText.getText();
            int transNo=Integer.parseInt(trans);
            fardRequestData fard=controllerObj.receiveFard(transNo);

            if(fard!=null)
            {
                message1.setText("Your Payment Status is Verified Successfully!!");
                message2.setText("You can receive your FARD");
                printButton.setVisible(true);
                downloadButton.setVisible(true);
            }

//            root = FXMLLoader.load(getClass().getResource("printFard.fxml"));
//            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();

        }

        else if (event.getSource() == printButton) {

            setActionLabel.setText("PRINTED!!");

        }
        else if(event.getSource()==downloadButton)
        {
            setActionLabel.setText("DOWNLOADED!!");
        }
        else if(event.getSource()==homeButton)
        {
            root= FXMLLoader.load(getClass().getResource("mainPage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        else if(event.getSource()==confirmPayButton)
        {
            root= FXMLLoader.load(getClass().getResource("confirmFard.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        }




    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       printButton.setVisible(false);
        downloadButton.setVisible(false);

    }
}

