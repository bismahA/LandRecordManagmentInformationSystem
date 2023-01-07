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

public class digitizedMapHandler {
    @FXML
    private Button verifyMapButton;
    Parent root;
    Stage stage;
    Scene scene;
    public void handleBUttons(ActionEvent event) throws IOException {
        if(event.getSource()==verifyMapButton)
        {
            root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
