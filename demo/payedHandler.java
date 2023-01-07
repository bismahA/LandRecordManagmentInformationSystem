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
import java.sql.SQLException;

public class payedHandler {

    @FXML
    private Button mainPageButton,homeButton,makePayButton,printFardButton;

    @FXML
    private Label transacLabel;
    Parent root;
    Stage stage;
    Scene scene;

    public void setLabel(int transacNo)
    {
        String trans=Integer.toString(transacNo);
        transacLabel.setText(trans);
    }

    public void handleBUttons(ActionEvent event) throws IOException, SQLException {

        if(event.getSource()==printFardButton)
        {
            root= FXMLLoader.load(getClass().getResource("printFard.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        }

       else if(event.getSource()==mainPageButton)
        {
            root= FXMLLoader.load(getClass().getResource("mainPage.fxml"));
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

        else if(event.getSource()==makePayButton)
        {
            root= FXMLLoader.load(getClass().getResource("makePayment.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
    }
    }
