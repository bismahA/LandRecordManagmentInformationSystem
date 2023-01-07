package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class confirmFardHandler {

    @FXML
    private Button firstFardButton;

    @FXML
    private Button homeButton;

    @FXML
    private Button makePaymentButton;

    @FXML
    private Button printFardButton;

    Parent root;
    Stage stage;
    Scene scene;
    @FXML
    public void handleBUttons(ActionEvent event) throws IOException {

        if (event.getSource() == firstFardButton) {
            root = FXMLLoader.load(getClass().getResource("fard.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        else if (event.getSource() ==makePaymentButton) {
            root = FXMLLoader.load(getClass().getResource("makePayment.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        else if (event.getSource() ==printFardButton) {
            root = FXMLLoader.load(getClass().getResource("printfFard.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
    }
}
